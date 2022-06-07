package part1recap

import scala.collection.immutable._

object ScalaCollection1 extends App {
  
    val list:List[String] =List("Hello","World","howdy")
    println(list)

    val listMix:List[Any]= List("hello","world",2)
    println(listMix)

    //adding element to list
    val oneElementAddedToList=list :+ "welcome"
    println(s"Added 1 new element to list ${oneElementAddedToList}")

    // maps

    val m :Map[String,Int] = Map("John"->23, "Alex"->21,"smith"->30)
    println(m)

    val personDetails:Map[String,(Int,String)] = Map("John"->(23,"USA"), "Alex"->(21,"MEXICO"),"smith"->(30,"ENGLAND"))
    println(personDetails)
}
