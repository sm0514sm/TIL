

fun main() {
    val array = arrayOf("가", "나")
    for ((index, value) in array.withIndex()){
        println("$index: $value")
    }
    for (i in array.indices) {
        println("$i: ${array[i]}")
    }
}