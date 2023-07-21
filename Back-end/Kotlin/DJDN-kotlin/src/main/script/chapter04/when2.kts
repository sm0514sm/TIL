fun whatToDo(dayOfWeek: Any) = when(dayOfWeek) {
	"Saturday", "Sunday" -> "Relax"
	in listOf("Monday", "Tuesday", "Wehnesday") -> "Work hard"
  in 2..4 -> "work hard"
  "Friday" -> "Party"
  is String -> "what?"
  else -> "No clue"
}

println(whatToDo("Sunday")) //Relax
println(whatToDo("Wednesday")) //work hard
println(whatToDo(3)) //work hard
println(whatToDo("Friday")) //Party
println(whatToDo("Mundaywojpgeowjgwe")) //what?
println(whatToDo(8)) //No clue