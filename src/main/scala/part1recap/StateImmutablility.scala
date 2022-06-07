package part1recap

import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.immutable.ParSeq

object StateImmutablility extends App {
  
    def isPrime(x:Int):Boolean = {
        (2 to Math.sqrt(x).toInt).forall(p => x % p ==0)
    }

    def countPrimePure(lim:ParSeq[Int]) = lim.filter(isPrime).length

    def countPrimeImpure(lim:Int) = {
        var count = 0
        val l = (1 to lim).toList.par
        l.map(x => if(isPrime(x)) count +=1)
        count
    }

    val s= countPrimePure(Stream.from(1).takeWhile(p => p < 100000).par)
    println(s"Prime Numbers between 1 to 1000 = ${s}")

    val cn = countPrimeImpure(100000)
    println(s"Prime number between 1 t0 1000 impure = ${cn}")
}
