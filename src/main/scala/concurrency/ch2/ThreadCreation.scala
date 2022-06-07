package concurrency.ch2

object ThreadCreation extends App {

    class MyThread extends Thread{

        override def run():Unit ={
            println("New Thread Running...")
        }
    }

    val  t: MyThread = new MyThread
    t.start()
    // join method stops the execution of main Thread
    // and put main thread in waiting state unitl
    // thread t completes is execution
    t.join()
    println("New Thread started/join")
    println("Added to vs code...")
    println("Added using commandline ...")
}
