val y:Option[Int] = None

val z:Option[String]= None

/**
  * Option is used in situation where a value may or may not present
  * and missing value is not an Error
  * missing value can be represented by None
  * 
  * while Some(x) means value is present
  */

case class Subscriber(name:String,email:String,phone:Option[Long])

// use pattern matching for access Option value
def digitsOf(x:Option[Long])= x match {
    case None => None
    case Some(s)=>Some(Seq(s))
}

def getDigits(phone:Option[Long]):Option[Seq[Long]] = phone match {
    case None => None // cannot obtain digits, return None
    case Some(x)=> digitsOf(Some(x))
}


Some(100).getOrElse(1)
None.getOrElse(10)

Some(100).map(x=>print(x))


// Either type
// has two values Left : Error And Right : Success

def logError(x:Either[String,Int],default:Int):Int = x match {
    case Left(error)=> print(s"Got an error $error"); default
    case Right(res)=>res
}

logError(Right(100),-1)
logError(Left("Bad Result"),-1)


Right(100).map(x => x+1)
Left("Some Error Occurs")

// try failure Success
import scala.util.{Try,Success,Failure}
val p = Try("xyz".toInt)
val q = Try("0002".toInt)