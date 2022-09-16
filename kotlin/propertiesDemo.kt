
//mutable extensible properties
var StringBuilder.firstCHAR:Char
    get() = get(2)
    set(value:Char) {set(0,value)}
class Computer{
    companion object
    {
        var hasDisplay:Boolean = true
            get() {
                println("static field's getter invoked")
                return field
            }
    }

    private var price:Int = 10_000
    var name ="Unknown"
        get()
        {
            println("getter invoked for name field")
            return field
        }
        set(value)
        {
            println("setter invoked for name field")
            field = value
        }
    var model = "M2300__"
        private set
    //we can get a value by processing other fields with getter of a field
    var isExpensive:Boolean= false
        get() = price > 5000
    //price can only be accessed by the same class members
    //check if expensive variable will invoke getter inside class
    override fun toString():String = "laptop : ${this.name} \nmode : $model\nprice : ${this.price}\nExpensive:$isExpensive\nhasDisplay : $hasDisplay"
}

fun main()
{
    var computer = Computer()
    //setter will be called
    computer.name = "Dell"
    //getter will be called
    println("via getter ${computer.name}")
    //accessing
    println("expensive ? :${computer.isExpensive}")
    //static values
    println(Computer.hasDisplay)
    //you cant read or write private field like java
    //computer.price
    println("\n\nvia toString method printing the object\n")
    println(computer)

    //mutable extensible properties
    var sb = StringBuilder("manish")
    println(sb.firstCHAR)
    sb.firstCHAR = 'M'
    println(sb)

}
