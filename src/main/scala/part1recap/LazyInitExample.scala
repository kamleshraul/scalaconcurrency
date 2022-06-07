package part1recap

object LazyInitExample extends App {
  /*Lazy execution means dealying the initialization of values*/

  /** lazy val z is assigned block of code
    * with value 100
    * lazy keyword tell scala not to initialize value of z
    * with value . When first call is made delibrately in code
    * then only initialize it's value
    */ 
  lazy val z = {
    println("Initializing demo with lazy")
    100
    }
    
    println("-------Lazy Initialization example----------")
    // following first call execute that block of code
    // and initialize z to 100
    z

    // this second call just use already initialize value
    // as z is declared as val i.e. initialize only once 
    //println(z)

    println("-----------Non-Lazy Initialization example--------")
    /** Not lazy val 
     * following statement get executed with object 
     * i.e. it is not waited for first call
    */
    val x = { println("Non lazy initialization "); 200}
    x // this is first call
    x // even though it is second call as it is val ,it won't execute block of code
    println(x)

    // calling method to initialize lazy blocks
    object AreaOfCircle{
        lazy val pi = {
            println("pi"); 
            3.14
        }
        lazy val r = {
            println("r");
            5
        }
        lazy val area = {
            println("area");
            pi*r*r
        }

        def calculate() = area
    }
    println("------- Calling Object Does not initialize lazy fields of class-------")
    AreaOfCircle
    println("--------Calling method initialize lazy blocks---------")
    AreaOfCircle.calculate()
    println(s"Area = ${AreaOfCircle.area}")


}
