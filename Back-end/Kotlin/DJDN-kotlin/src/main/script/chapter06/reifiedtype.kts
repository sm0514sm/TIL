abstract class Book(val name: String)
class Fiction(name: String) : Book(name)
class NonFiction(name: String) : Book(name)

val books: List<Book> = listOf(
	Fiction("Mody Dick"), NonFiction("Learn to Code"), Fiction("LOTR")
)

// ------------------------------------------------------------------- //
fun <T> findFirst1(books: List<Book>, ofClass: Class<T>): T {
	val selected = books.filter { book -> ofClass.isInstance(book) }
	if (selected.size == 0) {
		throw RuntimeException("Not found")
	}
	return selected[0] as T
}
println(findFirst1(books, NonFiction::class.java).name)

// ------------------------------------------------------------------- //
fun <T> findFirst2(books: List<Book>, ofClass: Class<T>): T {
	val selected = books.filter { book -> book is T }
	if (selected.size == 0) {
		throw RuntimeException("Not found")
	}
	return ofClass.cast(selected[0])
}
println(findFirst2(books, NonFiction::class.java).name)

// ------------------------------------------------------------------- //
inline fun <reified T> findFirst3(books: List<Book>): T {
	val selected = books.filter { book -> book is T }
	if (selected.size == 0) {
		throw RuntimeException("Not found")
	}
	return selected[0] as T
}
println(findFirst3<NonFiction>(books).name)