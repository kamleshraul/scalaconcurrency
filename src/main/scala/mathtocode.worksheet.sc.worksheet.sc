//factorial of 10
val fact10=(1 to 10).product
//factorial as function
def f(n:Int)=(1 to n).product
f(10)
// usign nameless function for factorial
val fac = (n:Int)=>(1 to n).product
fac(10)

// check number is prime or not

def isPrime(n:Int) = (2 to n-1).forall(k=> n%k !=0)
isPrime(12)
isPrime(17)

/**
 * bound variables -
 * variables that defined only inside expression and are
 * invisible outside.
 * 
 * Free variables
 * variables that are used in an expression but are defined
 * outside of the expression
*/

//Aggregating data from sequences

def isEven(n:Int)= (n % 2) match {
    case 0 => 1
    case _ => 0
}

def countEven(s:List[Int]) = s.map(isEven).sum

countEven(List(2,4,3,7,8,9,10))

2+3*(20/4)+10

/*Transformation 
* A function taking a list of values 
* and returning another list of values
*/
val list=List(2,3,10,20,17,12)
list.filter(x => x%2==0)
list.map(x => x*2)

/**
 * Aggregation
 * A function taking a list of values
 * and returning a single value
*/
list.sum
list.max