package leetcode

fun main() {
    var a = listOf<Int>(1,2,3,4,5)
    println(a)
    //
    var start =a[0];
    var sum =0
    var k=2-1;
    //first init
    for (index in 0 .. k)
        sum+=a[index]

    print("k=${k + 1} -> $sum")
    //sliding
    for (startIndex in 1..(a.size-1-k))
    {
        sum -= start
        sum+= a[startIndex+k]
        start = a[startIndex]
        print(" $sum")
    }

}