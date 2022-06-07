object SomeObject{
    def apply() = println("Some Object called")
}

SomeObject()

import com.codekam.akkaactors.actors._

Greeter()

// curried functions

// convert normal function to curried function
def sum(x:Int,y:Int,z:Int) = x+y+z
sum _
val convertedCurriedFunction = (sum _).curried