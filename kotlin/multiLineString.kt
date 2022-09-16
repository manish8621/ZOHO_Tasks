fun main()
{
    var msg = """
        hai <how are you mani>,how is it,bla bla bla......
    """
    var shortMsg = msg.trim { (it != '<') && (it != '>') }
    println(shortMsg)

    var msg1 = """  ko
        |hai
        |hello
    """.trimMargin()
    println(msg1)
}

