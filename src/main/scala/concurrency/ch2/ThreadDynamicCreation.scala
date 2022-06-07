package concurrency.ch2

object ThreadDynamicCreation extends App {
  
    /**
      * method used to create and start thread
      *
      * @param body is for passing a block of code to execute
      * in thread
      * @return thread
      */
    def thread(body: =>Unit):Thread ={
        val t = new Thread {
            override def run () = body
        }
        t.start()
        t
    }

    def log(msg:String)= println(s"${Thread.currentThread().getName()} -- :${msg}")

    val t = thread{
        // puts currently executing thread 
        // in timed waiting state
        Thread.sleep(1000)
        log("New thread running.......")
        Thread.sleep(1000)
        log("Still running...")
        Thread.sleep(1000)
        log("Completed...!!")
    }
    t.join()
    // thread t always execute in deterministics way
    // i.e. it output always remain consistent

    val nonDeterministicsThread=thread{log("New Thred Running NonDeterministics")}
    log("...")
    log("...")
    nonDeterministicsThread.join()
    // nonDeterministicsThread always executed non-deterministics way
    // i.e. it may execute in between log statements below it
    // or after or before log statements
    log("New Thread Joined !!!!")
}
