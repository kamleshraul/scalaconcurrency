package functionals

object funtional1 extends App {
  
    /**
     * In Functional Programming Need
     * 1) variables must to be immutable
     * 2) variable type must be known in advance 
     * 3) Those type must be applicable to body of
     *    function
     * 4) Variable values and it's types always remain fixed
     * 
    */

    def f(x:Int)= x*x+x

    println(s"f(10) = ${f(10)}")
}
