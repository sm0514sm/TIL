class Person(val first: String, val last: String) {
  var fulltime = true
  var location: String = "-"

  constructor(first: String, last: String, fte: Boolean) : this(first, last) {
    fulltime = fte
  }

  constructor(first: String, last: String, loc: String) : this(first, last, false) {
    location = loc
  }

  override fun toString() = "$first $last $fulltime $location"
}
println(Person("Jane", "Dow"))
println(Person("Jane", "Dow", false))
println(Person("Jane", "Dow", "home"))