fun main()
{
    //anonymous function
//    fun(i:Int){
//        println("i:$i")
//    }
    //storing anonymous function
    val myfun = fun(){println("welcome")}
    //call
    myfun.invoke()

    //referencing
    val quoteGenerator = ::printQuote
//    quoteGenerator.invoke()
    ((quoteGenerator).invoke())

}
fun printQuote()
{
    println("quote")
}