open class Fruit
class Banana: Fruit()
class Orange: Fruit()

fun receiveFruits1(fruits: Array<Fruit>) {
  println("Number of fruits: ${fruits.size}")
}
val bananas1: Array<Banana> = arrayOf()
//receiveFruits1(bananas1) // ERROR: type mismatch (제네릭에 대한 타입 불변성)


fun receiveFruits2(fruits: List<Fruit>) {
  println("Number of fruits: ${fruits.size}")
}
val bananas2: List<Banana> = listOf()
receiveFruits2(bananas2) // SUCCESS