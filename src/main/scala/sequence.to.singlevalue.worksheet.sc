/**Converting seq to single value*/

def digitsToInt(ds:Seq[Int]):Int ={
    val n=ds.length // length of sequence

    val powers:Seq[Int]=(0 to n-1).map{ k => math.pow(10,n-1-k).toInt}
    print(powers)

    (ds zip powers).map { case(a,b)=>a*b}.sum
}

digitsToInt(Seq(1,2,3,4))

/**Sum by recursion*/

def sum(s:Seq[Int]):Int = if(s.isEmpty) 0 else {
    val x = s.head // to split xs :+ x =s , get x first
    val xs = s.tail
    sum(xs)+x
}
sum(Seq(10,20,30))

/**length of sequence recursively*/

def lengthS(s:Seq[Int]):Int = if(s.isEmpty) 0 else 1 + lengthS(s.tail)
lengthS((1 to 100).toSeq)
//lengthS((1 to 100000).toSeq) // stackoverflow
import scala.annotation.tailrec
object tailRecursion{
//@tailrec def lengthS(s:Seq[Int]):Int = if(s.isEmpty) 0 else 1 + lengthS(s.tail)
@tailrec def lengthT(s:Seq[Int],res:Int):Int = if(s.isEmpty) res else lengthT(s.tail,res+1)
}
tailRecursion.lengthT((1 to 100).toSeq,0)
tailRecursion.lengthT((1 to 100000).toSeq,0)

//tailrecursion uses accumulator argument, so that last recursive call occurs at the end position of function
// if function is not tail recursive & @tailrec is used then application will not compile