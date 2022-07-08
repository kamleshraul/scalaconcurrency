/**
  * Aggregation converts a sequence of values 
  * into a single value
  */
  //following is not a tail-recursive function
  def f[A,B](s:Seq[A],b:B,g:(A,B)=>B):B = {
    if(s.isEmpty) b
    else g(s.last, f(s.take(s.length-1),b,g))
  }

  //tailrescursive function

  def leftFold[A,B](s:Seq[A],b:B,g:(B,A)=>B):B ={
    if(s.isEmpty) b
    else leftFold(s.tail,g(b,s.head),g)
  }

  def sum (s:Seq[Int]):Int = leftFold(s,0,(x:Int,y:Int)=>x+y)
  sum(Seq(10,20,70))

  /**
    * problem 1: find max value from sequence using foldLeft
    */

def max(s:Seq[Int]):Int = s.foldLeft(Int.MinValue){ (b,y)=> math.max(b,y)}
max(Seq(200,3,7,221,489,321))

/**
  * Find min,max,sum,mean from given sequence 
  * while traveling it only once
  */
type D4 = (Int,Int,Int,Int)
def update(p:D4,x:Int) = p match {
    case (min,max,sum,length)=> (math.min(x,min), math.max(x,max),sum+x,length+1)
}

def fm(s:Seq[Int]):(Int,Int,Int) = {
    val init:D4 =(0,0,0,0)
    val (min,max,sum,length)= s.foldLeft(init){update}
    (min,max,sum)
}

fm(Seq(10,20,30))

/**Implement map method which converts Seq[A] to Seq[B]
 * using foldLeft method
*/
def map[A,B](seq:Seq[A]) (f: A=>B) : Seq[B] = {
  seq.foldLeft(Seq[B]()){(acc,x)=> acc :+ f(x)}
}

map(Seq(222,333,444,555)){ x => x*2}

// convert sequence of character to double
def update(acc:(Double,Boolean,Double),c:Char)
  :(Double,Boolean,Double) = acc match {
    case(num,flag,factor) => if(c == '.')
      (num,true,factor)
      else{
        val digit = c -'0'
        if(flag)(num+digit/factor,flag,factor*10)// for digits after dots
        else (num*10+digit,flag,factor)// for digits before dots
      }
  }

def digitsToDouble(d:Seq[Char]):Double = {
  val initAcc = (0.0,false,10.0)
  val (num,_,_)= d.foldLeft(initAcc)(update)
  num
}

digitsToDouble(Seq('1','4','.','3','3'))
//1,false,10
//14,false,10
//14,true,10
//14.3,true,100.0
//14.3+3/100.0


def toPairs[A](xs:Seq[A],default:A):Seq[(A,A)]={
  
  type Acc = (Seq[(A,A)],Seq[A])
  
  def init:Acc = (Seq(),Seq())

  def updater(acc:Acc,x:A):Acc = acc match{
    case(result,Seq())=> (result,Seq(x))
    case(result,Seq(prev))=> (result:+((prev,x)),Seq())
  }

  val (result,holdover)=xs.foldLeft(init)(updater)

  holdover match {
    case Seq() => result
    case Seq(x) => result:+((x,default))
  }
}

toPairs(Seq(10,20,30,40,50),Some())

/**
  * Implement from pairs function to convert pairs to list
  * def fromPairs(seq:Seq[(A,A)]):Seq[A] = ???
  */

  def fromPairs[A](seq:Seq[(A,A)]) : Seq[A] = {
    seq.foldLeft(Seq[A]()){
      (acc,x) =>  x match {
        case (a,b) =>  acc :++ Seq(a,b)
      }
    }
  }
  fromPairs(Seq((1,2),(3,4)))

  /**
    * Implement flatten method using foldleft
    * def flatten[A](xxs: Seq[Seq[A]]): Seq[A] = ???
    * flatten(Seq(Seq(1, 2, 3), Seq(), Seq(4)))
    * Seq[Int] = List(1, 2, 3, 4)
    */

def flatten[A](xxs:Seq[Seq[A]]):Seq[A]= xxs.foldLeft(Seq[A]()){
  (acc,seq:Seq[A]) => acc :++ seq 
}
flatten(Seq(Seq(1, 2, 3), Seq(), Seq(4)))

/**
  * Use foldLeft to implement the zipWithIndex method for sequences. 
  * def zipWithIndex[A](xs: Seq[A]): Seq[(A, Int)] = ???
  * zipWithIndex(Seq("a", "b", "c", "d"))
  * Seq[String] = List((a, 0), (b, 1), (c, 2), (d, 3))
  */

def zipWithIndex[A](xs:Seq[A]):Seq[(A,Int)]= xs.foldLeft(Seq[(A,Int)]()){
  (acc,x) => acc :+ (x,xs.indexOf(x))
}
zipWithIndex(Seq("a", "b", "c", "d"))

