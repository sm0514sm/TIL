data class Task(val id: Int, val name: String, val completed: Boolean, val assigned: Boolean)

val task1 = Task(1, "Create Project", false, true)
println(task1) // Task(id=1, name=Create Project, completed=false, assigned=true)
println("Name: ${task1.name}") // Name: Create Project