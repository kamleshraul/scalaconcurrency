package part1recap

object AdvanceRecap extends App{

  // partial functions
  val partialFunction:PartialFunction[Int,Int]= {
    case 1 => 42
    case 2 => 65
    case 5 => 999
  }

  val lifted = partialFunction.lift
  println("lifted"+  lifted(2))
  println("Lifted 5000 " + lifted(5000))

  val pChain = partialFunction.orElse[Int,Int]{
    case 60 => 989
  }

  println("pChain 2 "+pChain(2))
  println("pChain 5 "+pChain(5))
  println("pChain 60 "+pChain(60))
  //println("pChain 1000 "+pChain(1000))


  implicit val timeout=3000
  def setTimeout(f:()=>Unit)(implicit timeout:Int) = f()

  setTimeout(() => println("timeout "+timeout))
}
