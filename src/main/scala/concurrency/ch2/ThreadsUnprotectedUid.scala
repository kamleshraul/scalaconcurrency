package concurrency.ch2
import ThreadDynamicCreation._

/**
  * Atomic execution of a block of code means that 
  * the individual statements in that block of code executed
  * by one thread cannot interleave with those statements by
  * another thread.
  * 
  * Every object inside JVM has special entity called an 
  * intrinsic lock or monitor, which is used to ensure that 
  * only one thread is executing some synchronized block on
  * that object
  * 
  * When thread starts executing the synchronized block, we 
  * say that the thread gains owership of that synchronized block
  * objects monitor and when thread completes it's execution of
  * synchronized block it releases monitor
  */

object ThreadsUnprotectedUid extends App{
  
    var uidCount = 0L
    /** this.synchronized make sure that no simultaneous 
     * thread executes following block of code
     * this keyword referes to the enclosing object of method
     * in this case ThreadsUnprotectedUid object.
     * this keyword is nessesary it will make sure that
     * no simultaneous thread executed synchronized blocks
     * even one thread executes on different synchronized block ,
     * it won't allow other thread to execute on different synchronized
     * block 
      */
    def getUniqueId() = this.synchronized{
        val freshUid = uidCount + 1
        uidCount = freshUid
        freshUid
    }

    def printUniqueIds(n:Int):Unit = {
        val uids = for(i<- 0 until n) yield getUniqueId()
        log(s"Generated uids:$uids")
    }

    val t = thread {printUniqueIds(5)}
    printUniqueIds(5)
    t.join()
}
