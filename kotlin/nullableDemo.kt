fun main()
{
    var s1:String?="hgvbbhj";
    println(s1.isEmptyOrNull())
    welcomeMsg("mani")
    welcomeMsg(8)
}
fun String?.isEmptyOrNull():Boolean = ((this?.length)?:0) == 0
fun <T> welcomeMsg(name:T){
    println("hai "+((name as? String)?:""))
}