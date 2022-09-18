import java.util.*

//i have to split the array until the array size becomes 1


fun main() {
    //[6, 5, 4, 3, 2, 1]
    var a = Array<Int>(6) { it -> 6 - it }
    mergeSort(a)
    println(a.contentToString())
}
fun mergeSort(a: Array<Int>, start:Int=0, end:Int = a.size-1)
{
    if(start == end)
    {
        print("${a[start]} ")
        return
    }
    else{
        val mid = (start+end)/2
        //rec call
        mergeSort(a,start,mid)
        mergeSort(a,mid+1,end)
        merge(a,start,mid,end)
    }
}

fun merge(a:Array<Int>,start:Int,mid:Int,end:Int) {
    //if the two sub arrays are single sized
    if(start +1 == end) {
        if (a[mid] > a[end]) {
            //swap
            val temp: Int = a[mid]
            a[mid] = a[end]
            a[end] = temp
        }
    }
        else
        {
            //sort the sub arrays ,either of them can be a single sized array
            var index=start
            var left = Array<Int>(mid-start+1){a[index++]}
            var right = Array<Int>(end-mid){a[index++]}
            //sorting
            var i=0
            var j=0
            index =start
            while (i<left.size && j<right.size)
            {
                if(left[i]>right[j])
                    a[index++] = right[j++]
                else
                    a[index++] = left[i++]
            }
            //copy remaining
            while (i<left.size)
                a[index++]=left[i++]
            while (j<right.size)
                a[index++]=right[j++]
        }
}
