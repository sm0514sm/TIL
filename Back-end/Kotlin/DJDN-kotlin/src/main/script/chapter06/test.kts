abstract class Person(val name: String)
class Student(name: String) : Person(name)
class Teacher(name: String) : Person(name)

val people: List<Person> = listOf(
	Student("AAA"), Teacher("BBB"), Student("CCC")
)

fun <T> findPerson1(poeple: List<Person>, ofClass: Class<T>): T {
	val selected = poeple.filter { person -> ofClass.isInstance(person) }
	if (selected.size == 0) {
		throw RuntimeException("Not found")
	}
	return selected[0] as T
}
println(findPerson1(people, Teacher::class.java).name)

fun <T> findPerson2(people: List<Person>, ofClass: Class<T>): T {
	val selected = people.filter { person -> person is T }
	if (selected.size == 0) {
		throw RuntimeException("Not found")
	}
	return ofClass.cast(selected[0])
}
println(findPerson2(people, Teacher::class.java).name)

inline fun <reified T> findPerson3(people: List<Person>): T {
	val selected = people.filter { person -> person is T }
	if (selected.size == 0) {
		throw RuntimeException("Not found")
	}
	return selected[0] as T
}
println(findPerson3<Teacher>(people).name)