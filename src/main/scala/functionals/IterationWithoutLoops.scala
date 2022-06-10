package functionals

object IterationWithoutLoops extends App {
  /** FP distinct feature is hadling iteration 
   * without loops
    * 
    */

    def sigma(xs:Seq[Double]):Double = {
        val n = xs.length.toDouble
        val xsum = xs.sum
        val x2sum = xs.map(i=>i*i).sum
        math.sqrt(x2sum/(n-1)-xsum*xsum/n/(n-1))
    }

    println(s"sigma(Seq(10,20,30)= ${sigma(Seq(10,20,30))}")
  
}
