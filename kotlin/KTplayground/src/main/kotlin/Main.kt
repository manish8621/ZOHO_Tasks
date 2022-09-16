
fun main(args: Array<String>) {

        var a="hi"
        var b ="your name"
        when (a) {
            "hi" -> {
                print("hi how are you");print("hai");
            }
            "im fine" -> print("nice")
        }

}
@JvmOverloads
fun add(b:Int,a:Int = 10)
{
    print(a)
}