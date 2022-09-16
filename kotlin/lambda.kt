class Animal(var name:String){
    fun whatsthisAnimal():String
    {
        return this.name
    }
    //+
    infix fun plus(b:Animal)= this.name+b.name
}










var i =0
fun topFun(i:Int):String
{
    return "from top fun $i"
}
infix fun Int.infixexample(j:Int) = this+j

fun main(args:Array<String>)
{
    var a = mutableListOf<Int>(1,2,3,4,5,6)
//    var m = mapOf<Int,String>(1 to "mani",2 to "game",3 to "code")
//    println(a)
//     var b = a.filter{it%2==0}
//    var b = a.map { 2*it }
//    var b = a.any{ it % 2 != 0 }
//    var b = a.find { it*2==100 }
//    var b = a.first { it*2==100 }
//    var b = a.count {it%2==0}
//    var b = a.partition { it%2==0 }
    var b = a.associate { it to it*10 }
   println(b)
//    var add = {a:Int,b:Int -> a+b}
//    var add:(Int,Int)->Int = {a,b -> a+b}
//
//
//
//    print(i)
    var obj = Animal("cat")
    var obj1 = Animal("dog")
//
//    //referencing function
//    //non-bound reference
    var nonBoundRef = Animal::whatsthisAnimal
//    //bound reference
    var boundRef= obj1::whatsthisAnimal
//
    println(nonBoundRef(obj))
    println(boundRef());   //eq obj1.whatsthisanimal
//
//    println()
//    println(1 infixexample 2);
//
//    //calling lambda directly
//    {i:Int,j:Int-> print(i+j) }(1,2)


//    //syntax
    val lambda:(Int,Int)->Int = {a,b->
        print("sdfds")
        var sum =0
        a+b
    }
//
    val lambda1 = {a:Int,b:Int ->
        print("$a $b")
        a+b
    }
    val lam:(Int)->Int = {it+1}
    println(lam(13))
////    print(lambda1(1,2))
//
    a.groupBy(lam)
    val firstChar1 : String.()->Char = {get(0)}
//    print("abc".firstChar1())



}
