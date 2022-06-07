package concurrency.ch2

import ThreadDynamicCreation._

object ThreadsCommunicate extends App {
  
    var result :String = null
    val t = thread{ 
        result = "\n Title\n"+"="*5
    }
    t.join()

    /**
      * Thread t writes to memory i.e variable result before
      * calling join() also, before join() methods returns
      * changes made to result variable is visible to main 
      * thread due to which main thread always print that
      * change value rather than null
      */
    log(result)

}
