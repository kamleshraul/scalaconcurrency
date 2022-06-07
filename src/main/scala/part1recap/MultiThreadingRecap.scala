package part1recap

object MultiThreadingRecap extends App {
  
  //creating thread in jvm
  
  val aThread = new Thread(new Runnable{
    override def run(): Unit = println(" I'm running in parallel")
  })

  aThread.start()

  val threadHello = new Thread(()=>(1 to 1000).foreach(_=>println("hello")))
  val threadGoodBye = new Thread(()=>(1 to 1000).foreach(_=>println("goodbye")))
  threadHello.start()
  threadGoodBye.start()
}

