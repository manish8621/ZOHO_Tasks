fun main()
{
    //iterate over string
    val vow ="aeiouAEIOU"
    for(c in vow)
    {
        print(" $c")
    }
    var ch = 'a'
    if(isvow(ch,vow))
        println("\n $ch is a vowel")


    println("to" in "aa".."zz")
}
fun isvow(ch:Char,vowels:String):Boolean = (ch in vowels)