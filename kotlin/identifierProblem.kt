


fun isValidIdentifier(s: String): Boolean {
    if(s.isEmpty()) return false
    if (!(s.firstChar().isLetter() )&& s.firstChar() != '_') return false
    for(index in 1 until s.length)
            if( !s[index].isLetter() && s[index] !='_' && !s[index].isDigit())
                return false
    return true
}

fun main(args: Array<String>) {
//    print(isValidIdentifier("name"))
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}