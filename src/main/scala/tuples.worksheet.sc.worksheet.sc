// tuple of pair
val a:(Int,String) = (123,"xyz")
// tuple of triple
val b:(Boolean,Int,Int)=(true,3,4)
/**
  * Tuple can contains any number of values
  * which are called as Parts of tuple
  * Parts of tuple can have different types
  * this type fixed only once i.e. we cann't 
  * change type of parts once defined
  * Number of parts tuples cannot be changed
  * Once it is defined
  */

  //accessing parts of tuples
  // tuple accessor method
  a._1

  /**
    * Function which has argument as tuple
    */
def f(p:(Boolean,Int),q:Int):Boolean = p._1 && (p._2>q)

/**
  * Pattern matching in tuples done by 
  * destructuring
  * case expression
  */

  // destructuring of definition

  val (x,y,z) = (10,20,30)
  //above x, y , z are called as pattern variables

  // case expression

  (1,2,3) match {
      case(a,b,c) => a+b+c
  }

  def t1(p:(Int,(String,Int))):String = p match {
      case (x,(str,y)) => str +(x+y).toString
  }

  t1(10,("result is ",2))

  // _ will ignore part of pattern
  val (x1,_,_,z1)=("abc",1,2,10)

  //tuples with collection

  val r:List[(String,Int)]=List(("apple",3),("oranges",2),("pears",3))

  r.map{case (fruit,count)=>count*2}

  //using tuples for dictonary as collections
  Map(("apples",3),("Orange",10),("Pear",33))
  List(("apples",3),("Orange",10),("Pear",33)).toMap

  "apple"->3
  
  val fruitBasket=Map("appled"->98,"grapes"->45,"JackFruit"->35)

// convert map to list of tuples
Map("apple"->100,"grapes"->40,"banana"->30).toSeq

// using map on dictionary object

fruitBasket.map{ case (fruit,count)=> count * 2}

val fruitsBasketWithCost:Seq[(String,Int,Int)]=fruitBasket.map { case(fruit,count) => (fruit,count,count*2)}.toSeq

// filter over dictionary
// want fruits which cost less than 100
fruitsBasketWithCost.filter {
  case(fruit,count,cost) => cost<100
}

// zip and zip with index

val list1 = List(1,2,3)
val list2 = List("One","Two","Three")
list1.zip(list2)
// with dictory object we can use zip 
// in this case key value converted in to tuple
// and map considered as sequence of Tuple
fruitBasket.zip(list1)

// flatten method converts nested sequences to one
//flattern method computes concatenation of inner sequences
// flattern method removes only one level of nesting
val listOfLists = List(List(1,2,3),List(11,22,33),List(111,222,333))
listOfLists.flatten

List(1,2,3) ++ List(111,222,333) ++ List(11,22,33)

/**
  * flatMap if shorcut of applying maping function 
  * and then using flattern function
  * flatMap is related to monads
  */

val listN:List[List[Int]]=List(1,2,3).map(n=> (1 to n).toList)
listN.flatten

//above can be written in one flatMap statement
List(1,2,3).flatMap { 
  n => (1 to n).toList
}

/**
  * groupBy method rearranges a sequence into a dictionary
  * the key of dictionary is computed by the function
  * that we pass to groupBy , key can be anything 
  * we want , which is the result of that function
  */

  val seqOfWords:Seq[String]=Seq("wombat","xanthan","yogurt","zebra")
  // group the words starts with letter 'y' in one sequnece 
  // and remaining in others
  seqOfWords.groupBy{
    w => if(w.startsWith("y"))1 else 2
  }


/**
  * sliding method create a sequence of sliding windows
  * of given width
  */
  (1 to 10).sliding(4).toList

/**
  * sortBy
  */
// sort reverse
List(1,2,3).sortBy(x => -x)
//sort by word lenght
List("xx","yyyy","z").sortBy( w=> w.length())

/**
  * sorted is similar to sortBy only it used
  * in cased where elements in sequence has
  * natural ordering like sequence elements are
  * of type Int,float,String etc
  */
  List(22,5,2,9,4).sorted


  val bs = List(1,2,3,4,5)
  val lst=bs.sliding(3).toList
  