package part1recap

/** 
  * Combine many functions to output a new function
  * 
  * Curring is process of converting  a function with multiple arguments
  * into a sequence of functions where each function takes one arguments.
  * Each function another function that consumes following argument
  */
object FunctionComposition extends App {
  
    def lift(ls:List[Int]) = ls map {x=>Option(x)}

    def findNElem(elem:Int,ls:List[Option[Int]]) :Boolean = ls match{
        case Nil => false
        case x::xs => if(elem == x.get) true else findNElem(elem,xs)
    }

    //curried function using _ and curried keyword
    val findElementCurried=(findNElem _).curried
    // findElementCurried:(Int => (List[Option[Int]] => Boolean))

    val fcomp1 = findElementCurried(3) compose lift _

    val isFound=fcomp1(List(1,2,3))
    println(s"Found 3 in list ${isFound}")
}
