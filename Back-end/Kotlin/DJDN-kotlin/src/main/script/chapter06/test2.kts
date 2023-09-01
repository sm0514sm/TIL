open class Animal(val name: String)
class Dog(name: String) : Animal(name)

fun printAnimalInfo(animals: List<Animal>) {
  for (animal in animals)
    println(animal.name)
}

fun printDogInfo(animals: List<Dog>) {
  for (animal in animals)
    println(animal.name)
}

//printDogInfo(listOf(Animal("animal")))
printAnimalInfo(listOf(Dog("dog")))
