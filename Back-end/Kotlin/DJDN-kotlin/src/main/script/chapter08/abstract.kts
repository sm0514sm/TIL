abstract class Musician(val name: String, val activeFor: Int) {
    abstract fun instrumentType(): String
}

class Cellist(name: String, activeForm: Int) : Musician(name, activeForm) {
    override fun instrumentType() = "String"
}

val ma = Cellist("Yo-Yo Ma", 1961)