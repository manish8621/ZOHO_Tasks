fun main() {
    var p = Person("mani",21)

    //with returns lambda result
    //context object this
    var ageAfter5Years = with(p) {
       println("age is $age")
       age+5
    }
    println("after 5 years $ageAfter5Years")
    //apply returns context object
    //context object :this
    val p1 = Person("gojo",22)
    p1.apply {
        name = "@"+name
        age-1
    }
    println(p1)
    //also return s the object ant can be accessed with "it "
    var p2 = Person("hojuko",18).also {
        it.name="#"+it.name
        it.age +=1
    }
    //let is mostly used in nullPointer Exception situations,context object it,returns lambda result
    var p3:Person? = Person("nuo",9)
    //combined with safe access
    p3?.let {
        println(it.name)
    }
    //run
    var p4 = Person("runner",90)
    var new_name = p4.run {
        name+"<>"
    }
    println(new_name)

}
data class Person(var name:String ,var age:Int)
{
    override fun toString(): String {
        return "name : $name ,age:$age"
    }
}