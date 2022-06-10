def isPrime(n:Int):Boolean =(2 to n-1)
    .takeWhile(k => k*k <=n)
    .forall(k => n % k !=0)
isPrime(12)
isPrime(17)
isPrime(13)

(1 to 10 )
    .map(k => Math.abs(Math.sin(k+2)))
    .product

(1 to 10)
    .takeWhile(k => Math.cos(k)>0)
    .map(k => Math.sqrt(math.cos(k)))
    .sum