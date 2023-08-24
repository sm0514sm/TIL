class MachineOperator private constructor(val name: String){
  fun checkin() = checkedIn++
  fun checkout() = checkedIn--
  companion object {
    var checkedIn = 0
    fun minimumBreak() = "15 minutes every 2 hours"
    fun create(name: String): MachineOperator {
      val instance = MachineOperator(name)
      instance.checkin()
      return instance
    }
  }
}

val operator = MachineOperator.create("Mater")
println(MachineOperator.checkedIn)