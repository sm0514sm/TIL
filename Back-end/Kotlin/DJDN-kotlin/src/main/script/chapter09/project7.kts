interface Worker {
    fun work()
    fun takeVacation()
    fun fileTimeSheet() = println("why? really?")
}
class CSharpProgrammer : Worker {
    override fun work() = println("...write C#")
    override fun takeVacation() = println("...brand at the ranch")
}

interface Assistant {
    fun doChores()
    fun fileTimeSheet() = println("No escape from that")
}

class DepartmentAssistant: Assistant{
    override fun doChores() = println("routine stuff")
}

class Manager(val staff: Worker, val assistant: Assistant): Worker by staff, Assistant by assistant {
    override fun takeVacation() = println("of course")
    override fun fileTimeSheet() {
        print("manually")
        assistant.fileTimeSheet()
    }
}

val doe = Manager(CSharpProgrammer(), DepartmentAssistant())
doe.work()
doe.takeVacation()
doe.doChores()
doe.fileTimeSheet()