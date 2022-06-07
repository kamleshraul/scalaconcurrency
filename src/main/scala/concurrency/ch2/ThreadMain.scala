package concurrency.ch2

object ThreadMain extends App {
  
    val t:Thread=Thread.currentThread()
    val name = t.getName()
    println(s"I am in thread ${name}")
}
