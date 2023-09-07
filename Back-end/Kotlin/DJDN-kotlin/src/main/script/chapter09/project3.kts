interface Worker {
    fun work()
    fun takeVacation()
}

class JavaProgrammer: Worker {
    override fun work() = println("...write Java")
    override fun takeVacation() = println("...code at the beach")
}

class CSharpProgrammer: Worker {
    override fun work() = println("...write C#")
    override fun takeVacation() = println("...brand at the ranch")
}

// 팀을 관리하기 위한 소프트웨어 개발 매니저 상속
class Manager(val worker: Worker){
    fun work() = worker.work()
    fun takeVation() = worker.work()
}

val doe = Manager(JavaProgrammer())
doe.work()