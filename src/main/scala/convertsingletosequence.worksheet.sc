//converting single value to sequence
//Aggregation means folding
//Conversion from single value to sequence means unfolding

/*unfolding operation needs to build a sequnece whose length 
 is not determined in advance this kind of sequnece is called
 as stream
 Elements of streams are computed only when necessary
*/

/**
  * General stream producing function in scala is Stream.iterate
  */

Stream.iterate(2){x => x +2}
Stream.iterate(2){x => x + 2}.take(6).toList

Seq(10,20,30,40,50).drop(3)
Stream.iterate(10){x => x + 10}.drop(3).take(2).toList

def digitsOf(n:Int):Seq[Int] = {
    if(n == 0)
        Seq(0)
    else {
        Stream.iterate(n){ nk => nk/10}
        .takeWhile { nk => nk !=0}
        .map{ nk => nk % 10}
        .toList.reverse

    }
}

digitsOf(2033)
digitsOf(34567)


// convert sequence into another sequence using some relation
// between elements of sequences

def scanLeft[A,B](xs:Seq[A])(b:B)(next: (B,A) => B):Seq[B] = {
    val init : (B,Seq[B]) = (b,Seq(b))

   val (_,result)= xs.foldLeft(init){
        case ((b,seq),x) => {
            val newB = next(b,x)
            (newB,seq:+ newB)
        }
    }

    result
}

scanLeft(Seq(1,2,3,4,5))(0){ (x,y) => x +y}
