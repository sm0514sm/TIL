package `04_Classes_and_Inheritance`

class Customer1(name: String) {
    var name = name
    init {
        println("이름: $name")
    }
}

class Customer2(var name: String) {
    init {
        println("이름: $name")
    }
}

fun main() {
    val customer1 = Customer1("상민1")
    val customer2 = Customer2("상민2")
    println(customer1)
    println(customer2)

    // getter setter 필요없음
    customer1.name = "코틀린 상민1"
    customer2.name = "코틀린 상민2"
    println(customer1.name)
    println(customer2.name)
}