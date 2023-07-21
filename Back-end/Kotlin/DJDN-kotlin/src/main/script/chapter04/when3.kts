fun printWhatToDo(dayOfWeek: Any) {
	when(dayOfWeek) {
		"Saturday", "Sunday" -> println("Relax")
		in listOf("Monday", "Tuesday", "Wehnesday") -> println("Work hard")
	  in 2..4 -> println("work hard")
	  "Friday" -> println("Party")
	  is String -> println("what?")
	  else -> println("No clue")
	}
}

printWhatToDo("Sunday") //Relax
printWhatToDo("Wednesday") //work hard
printWhatToDo(3) //work hard
printWhatToDo("Friday") //Party
printWhatToDo("Mundaywojpgeowjgwe") //what?
printWhatToDo(8) //No clue