/**
  * Pattern matching in case classes
  * 
  * destructuring definition : val pattern = ...
  * case expression : case pattern =>
  */

  //destructuring definition 

  case class MySock(size:Double,color:String)
  case class BagOfSocks(sock:MySock,count:Int)

  def printBag(bag:BagOfSocks):String ={
    //Destructure the 'bag'
    val BagOfSocks(MySock(size,color),count)=bag
    s"bag has $count $color socks of size $size"
  }

  val bag = BagOfSocks(MySock(10,"Gray"),8)
  printBag(bag)

  def fits(bag:BagOfSocks):Boolean = bag match {
    case BagOfSocks(MySock(size,_),_) => (size >= 10.5 && size )
  }