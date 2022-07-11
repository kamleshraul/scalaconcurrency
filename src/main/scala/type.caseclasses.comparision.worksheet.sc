// compare tuples and case classes

// tuple can be represented as case class

case class Tuple2[A,B](_1:A,_2:B)
case class Tuple3[A,B,C](_1:A,_2:B,_3:C)

val tu2=Tuple2(10,"Ten")
tu2._1

// tuple with 1 part in there Tuple1[A] which rarely used
val onePartTuple =(10)

// tuple with no part is also there but it represented as Unit

val noPartTuple = ()

// similar to empty tuple we can define empty case class

case class EmptyCaseClass()
val emp=EmptyCaseClass

//difference between case class and case object

case class C() // 1) can be parameterized     2) C() will cause allocation of new memory location
case object CO // 2) can not be parameterized 2) CO only allocate one memory location in lifetime


// representing different types for single result
// sealed trait / final class is used to represent type 
// also called as disjuctive type
// that allow to select one choice from fixed set of classes
sealed trait RootsOfQ
final case class NoRoots() extends RootsOfQ
final case class OneRoot(x:Double) extends RootsOfQ
final case class TwoRoots(x:Double,y:Double) extends RootsOfQ

sealed trait SearchResult
final case class Index(i:Int) extends SearchResult
final case class NotFound() extends SearchResult

sealed trait Result[A]
final case class Value[A](x:A) extends Result[A]
final case class Error[A](message:String) extends Result[A]


val x:RootsOfQ = OneRoot(1.0)

def f(r:RootsOfQ):String = r match{
    case NoRoots() => "No real roots"
    case OneRoot(one) => s"one root is $one"
    case TwoRoots(x,y) => s"real roots are $x : $y"
    case _ => "Something else may be the answer"
}

f(x)

// for disjunctive type all match cases should 
// be exists in pattern matching
/*def g(r:RootsOfQ):String = r match{
    case NoRoots() => "No real roots"
}
g(x)*/