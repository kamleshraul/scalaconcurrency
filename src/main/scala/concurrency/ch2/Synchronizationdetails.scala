package concurrency.ch2

import scala.collection.mutable.ArrayBuffer
import ThreadDynamicCreation._
import ThreadsUnprotectedUid._

/**
  * Synchronization mechanism that enforces access limits on 
  * shared resource is called lock.
  * 
  * Locks are used to ensure that no two threads execute the
  * same code simultaneously . It is called as Mutual Exclusion
  * 
  * A thread can own monitors of several different objects simultaneously.
  * Synchronized blocks can be nested
  */
object Synchronizationdetails extends App {

    private val transfers = ArrayBuffer[String]()

    def logTransfer(name:String,n:Int)=transfers.synchronized{
        transfers +=s"transfer to account '$name' = '$n' "
    }

    class Account(val name:String,var money:Int){
        val uid = getUniqueId()
    }

    def add(account:Account,n:Int) = account.synchronized{
        account.money += n
        if(n>10) logTransfer(account.name,n)
    }

    // it result in deadblock
    def send(a:Account,b:Account, n:Int) = a.synchronized{
        b.synchronized{
            a.money -=n
            b.money +=n
        }
    }

    def sendNoBlock(a1:Account,a2:Account,n:Int){

        def adjust(){
            a1.money -= n
            a2.money +=n
        }

        if(a1.uid < a2.uid)
        a1.synchronized{ a2.synchronized(adjust())}
        else
        a2.synchronized{ a1.synchronized(adjust())}
    }


    val jane = new Account("Jane", 100)
    val john = new Account("John",200)

    val t1 = thread { add(jane,5)}
    val t2 = thread { add(john,50)}
    val t3 = thread { add(jane,70)}
    t1.join()
    t2.join()
    t3.join()
    log(s"----- Transfers ------- \n $transfers")

    val a = new Account("Jack",1000)
    val b = new Account("Jill",2000)
    val t4 = thread{ for(i<- 0 until 100) sendNoBlock(a,b,1)}
    val t5 = thread{ for(i<- 0 until 100) sendNoBlock(b,a,1)}
    t4.join();t5.join()
    log(s"a = ${a.money} , b = ${b.money}")
}

