package concurrency.ch2

import scala.collection.mutable.Queue
import ThreadDynamicCreation._

object SynchronizedBadPool extends App {
  
    private val tasks = Queue[()=>Unit]()

    val worker = new Thread { 
        
        def poll():Option[()=>Unit] = tasks.synchronized{            
            if (tasks.nonEmpty) 
                Some(tasks.dequeue()) 
            else 
                None
        }

        override def run() = while(true) poll() match {
            case Some(task) => task()
            case None =>
        }
    }

    worker.setName("Worker")
    worker.setDaemon(true)
    worker.start()

    def asynchronous(body: => Unit) = tasks.synchronized{
        tasks.enqueue(() => body)
    }

    asynchronous( log("Hello"))
    asynchronous( log(" World !"))
    Thread.sleep(5000)
}
