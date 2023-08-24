import java.lang.RuntimeException

class Person(val first: String, val last: String){
  // ...
  internal fun fullName() = "$last, $first"
  private fun yearsOfService(): Int = throw RuntimeException("Not implemented yet")
}
