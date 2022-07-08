/*
Total function always computes a result as value
Partial function fail to compute result for some arguments
*/

//Seq(1).tail.max // max called on empty sequence which throu
//exception , so input in wrong for that function

def h(p:(Int,Int)):Int = p match {
    case (x,0)=> x
    case _ => 0 // match everything
}
h(1,0)
h(1,2)
//h(12,3,3) //wrong input error

/**
  * Lazy value evaluated at first call and 
  *  stays in memory and will not re-computed.
  * On-Call value recomputed on each call
  * scala uses def keyword for that
  */
  Seq(10,20,30,40,50).view

  (1 to 10).view.flatMap(x => 1 to 3).max

  val iter = (1 until 10).iterator
  iter.toList
  iter.toList
  iter

  // type alias
  type MySocksTuple = (Double,String)
  type PaymentTuple = (Double,String)
  val s:MySocksTuple = (10.5,"White")
  val p:PaymentTuple = (25.0,"restaurant")

  def totalAmount(ps:Seq[(Double,String)])={
    ps.map(_._1).sum
  }

  val seq:Seq[(Double,String)]= s :: p :: Nil
  totalAmount(seq)


  case class MySocks(size:Double,color:String)
  case class Payment(amount:Double,name:String)

  val socks = MySocks(10.5,"White")
  val paid = Payment(25.0,"restaurant")


  // typed classes

  case class MySocks_Int(size:Double,color:String,value:Int)
  case class MySocksX[A](size:Double,color:String,value:A)

  val ms= MySocksX(10,"Neon",20)

  val oneTuple:(Int) = (10)
  val noValueTuple:Unit = ()

