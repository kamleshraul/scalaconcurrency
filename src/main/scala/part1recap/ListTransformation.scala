package part1recap

object ListTransformation extends App {
  
    val ints:List[Int]=List(1,2,3,4)
    println(s"Original List ${ints}")

    // map
    val addedOne=for(i<-ints) yield i+1
    println(s"After Adding 1 ${addedOne}")

    val mapAddedOne=ints.map{x => x+10}
    println(s"Used map to add 10 : ${mapAddedOne}")

    val conditionalMap=ints.map{x=> if(x%2==0) x+100 else x}
    println(s"Conditional Map to add 100 to even numbers : ${conditionalMap}")

    // flatmap convert list of list to single list
    val listOfStrings:List[String]=List("hello","world","howdy")
    val flatMapList=listOfStrings.flatMap{f => List(f+"$")}
    println(flatMapList)
}
