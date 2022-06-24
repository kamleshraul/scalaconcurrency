/**
  * For a given k>0 compute sequence
  * c = max(bi-k,....,bi+k)
  * that means for every bi element in sequence
  * find 2k+1 nearby elements & find max element
  * from those nearby elements
*/
  val bs = List(1,2,3,4,5)
  //sliding will give use near by elements
  bs.sliding(3).toList
  //max will calculate max element from that 
  // sub windows
  bs.sliding(3).map{
    nestedList => nestedList.max
  }.toSeq


  /**
    * Print table of 10 * 10
    * such that output is dictionary
    * Map[(Int,Int),Int] 
    */
    (1 to 10).flatMap {
        x => (1 to 10).map{
            y => (x,y)-> x*y
        }
    }
    .toSeq

/**
  * For Xi find max of x,xi2,cosxi,sinxi
  */
import Math._
List(0.1,0.2,0.5).flatMap{
    x => Seq(x,x*x,cos(x),sin(x))
}.max

//or can be writtern as
List(0.1,0.2,0.5).map{
    x => Seq(x,x*x,cos(x),sin(x))
}.flatten.max

/*reverse key values in dictionary*/

def rev[Name,Address](dict:Map[Name,Address]):Map[Address,Name] = dict.map{
    case (name,address)=> (address,name)
}.toMap

val d = Map(true->Seq("x","y"),false->Seq("a","b"))
rev(d)

// specifiying type parameter at the time of calling a function
rev[Boolean,Seq[String]](d)

/** In a given list of word calcuate length of word
  * and return Seq(List[String],Int)
  */
Seq("the","food","good","is","a").groupBy {
    word => word.length
}.map{
    case (a,b)=>(b,a)
}


/**
  * Find all pairs 8, 9 within ¹0, 1, ..., 9º such that i+4*j>i*j .
  */
(1 to 9).map{x=>
    (1 to 9).map{ y=>
        (x,y)
    }.toSeq.filter{
        case (x,y) => x + 4*y > x*y
    }
}


/**
  Given two sequences p: Seq[String] and q: Seq[Boolean] of equal length, compute a
Seq[String] with those elements of p for which the corresponding element of q is true
* 
*/

val p:Seq[String]=List("word","of","scala","jvm")
val q:Seq[Boolean]=Seq(true,false,true,true)
p zip q filter {
    case (a,b)=> b==true
} map {
    case (a,b) => a
}

/**
  * Given p: Seq[String] and q: Seq[Int] of equal length, compute a Seq[String] that
contains the strings from p ordered according to the corresponding numbers from q. For example, if
p = Seq("a", "b", "c") and q = Seq(10, -1, 5) then the result must be Seq("b", "c", "a")
  */

val lst = Seq("a", "b", "d","z")
val nlst = Seq(10,2,7,15)


lst.zip(nlst).map{
    case (a,b)=> (b,a)
}.toSeq .sortBy {
    case (b,a) => b
}.map{
    case (b,a)=> a
}

/**
 * p:Seq[String] and q:Seq[Int] of equal length and assuming that values in q do
 * not repeat, compute a Map[Int, String] mapping numbers from q to the corresponding strings from p
*/

val plist = List("abc","xyz","pqr","khg")
val qlist = List(3,10,33,2)
(qlist zip plist).toMap

def listToMap[P,Q](p:Seq[P],q:Seq[Q]):Map[Q,P] = (q zip p).toMap
listToMap(plist,qlist)


/**
 * Given a Seq[(String, Int)] showing a list of purchased items (where item names
may repeat), compute a Map[String, Int] showing the total counts
*/

val listOfFruitsCount=Seq(("apple", 2), ("pear", 3), ("apple", 5), ("lemon", 2), ("apple", 3))
listOfFruitsCount.groupBy{
  (a,b)=> a
}.map {
  case( a-> b) => (a,b.map {
    case(x,y) => y
  }.sum)
}

/**
 * Given a Seq[List[Int]], compute a new Seq[List[Int]] where each inner list contains
three largest elements from the initial inner list (or fewer than three if the initial inner list is
shorter)
*/

val seqOfList:Seq[List[Int]]= Seq((1 to 10).toList,(50 to 55).toList,(221 to 228).toList)

seqOfList.map{
  lst => lst.sortBy(x => -x).take(3)
}

/**
 * Given two sets, p: Set[Int] and q: Set[Int], compute a set of type Set[(Int,
Int)] as the Cartesian product of the sets p and q; that is, the set of all pairs (x, y) where x is an
element from the set p and y is an element from the set q
*/

def cartesian[I,J](p:Set[I],q:Set[J]):Set[(I,J)] ={
  p.map{ a => q.map { b=>(a,b)}}.flatten
}

cartesian(Set("a","b"),Set(10,20))

/**
 * Given a Seq[Map[Person, Amount]], showing the amounts various people paid on
each day, compute a Map[Person, Seq[Amount]], showing the sequence of payments for each person
*/

def paymentMadeByPerson[Person,Amount](elm:Seq[Map[Person,Amount]]) = {
  elm.flatMap{
    m => m.toSeq
  }.groupBy{
    (a,b)=> a
  }.map {
    case h->l => (h, l.map{
      case (a,b)=>b
    })
  }
  /*.mapValues{
    lst => lst.map {
      case(a,b)=>b
    }
  }*/
}.toMap

paymentMadeByPerson(Seq(Map("Tarski" -> 10, "Gödel" -> 20)
, Map("Church" -> 100, "Gentzen" -> 50),
Map("Tarski" -> 50)
, Map("Banach" -> 15, "Gentzen" -> 35)))

val mMap = Map(1->"One",2->"Two",3->"Three")
mMap.mapValues{
  m => m
}.toMap