//It is always helpful to define parts for tuples with names
// disjuctive = lack of consistency
//a tuple representing size and color of socks
val socks:(Double,String)=(8,"white")

// but it can be used in other context to respresent something else
// like payment and paid at

val amountPaid:(Double,String) = socks

// it is errorneous in code to add type for it we can used
// type alias or class or trait or opaque type

// type alias
type MySocksTuple = (Double,String)
type PaymentTuple = (Double,String)

val mySocks:MySocksTuple =(10,"gray")
val paymentMade:PaymentTuple = mySocks // this also not prevent errorneous

// case classes can be seen as tuples with names

case class MySocks(size:Double,color:String)
case class MyPayments(amount:Double,paidAt:String)

val sock=MySocks(9,"Blue")
//val myPayments:MyPayments=sock is will give type error now
sock.size
sock.color

// typed case classes

case class MySocks_Int(size:Double,color:String,value:Int)
case class MySocks_Boolean(size:Double,color:String,value:Boolean)

//above can be written as Parameterized Case class

case class MySocksPara[A](size:Double,color:String,value:A)
val s = MySocksPara[Int](3.4,"blue",10)
val bs=MySocksPara[Boolean](10.4,"gray",true)

// method using parameterized case class

def fits[A](socks:MySocksPara[A]):Boolean = {
    if(socks.size >8 && socks.size<11) true else false
}

fits(s)
fits(bs)

// type constructor in case classes
// constructor which is defined using parameter
// parameterized constuctor can ommit Type like D never used
// in following example
case class Complicated[A,B,C,D](x:(A,A),y:(B,Int)=>A,z:C =>C)