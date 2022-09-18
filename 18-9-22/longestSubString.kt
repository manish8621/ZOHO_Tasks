package leetcode
fun String.findFirst(startIndex:Int,endIndex:Int):Int
{
    var charFoundAt = -1
    for(index in startIndex until endIndex)
        if(get(index) == get(endIndex)){
            charFoundAt=index
            break
        }
    println(charFoundAt)
    return charFoundAt
}
fun main() {
    val s = "pwwkew"
    print("$s has longest substring of length ${lengthOfLongestSubstring(s)}")
}
fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    var len= 1
    var start=0
    var end=1
    var subStr = s[start].toString()
    while(end < s.length)
    {
        //check if end char is already exist in sub array
        val duplicateIndex = s.findFirst(start,end)
        //add to string and continue
        if(duplicateIndex==-1) {
            subStr += s[end]

            //update max len
            if(subStr.length>len)
                len = subStr.length;
        }
        else  {
            //if duplicate found at last
            if(end == s.length-1) break
            //update max len
            println("len:$len")
            if(subStr.length>len)
                len = subStr.length;
            //update the sub string
            start = duplicateIndex + 1
            subStr=""
            for (index in start .. end)
                subStr += s[index]
            println("sub $subStr $start $end")
        }
        end++
    }
    return len
}