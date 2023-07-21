val array = arrayOf(1, 2, 3)
for (e in array) { print("$e, ") } //1, 2, 3

val list = listOf(1, 2, 3)
println(list.javaClass) // class java.util.Arrays$ArrayList
for (e in list) { print("$e, ") } //1, 2, 3
println()

val names = listOf("Tom", "jerry", "spike")
for (index in names.indices) {
  println("$index: ${names.get(index)}")
}
println()
for ((index, name) in names.withIndex()) {
  println("$index: $name")
}