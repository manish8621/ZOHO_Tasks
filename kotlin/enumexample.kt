
fun main(args:Array<String>)
{
    var a = 10
    var b = 2
    var c=3
    val(d,r) = when(a)
    {
        1->Pair(1, 2)
        else -> 2 to 3
    }
    print("$d $r")
    for (i in 2..10 step 2)
        print(" $i")


}
