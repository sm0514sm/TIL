open class Vehicle(val year: Int, open var color: String) {
    open val km = 0
    final override fun toString() = "year: $year, Color: $color, KM: $km"
    fun repaint(newColor: String) {
        color = newColor
    }
}

open class Car(year: Int, color: String) : Vehicle(year, color) {
    override var km: Int = 0
        set(value) {
            if (value < 1) {
                throw RuntimeException("can't set negarive value")
            }
            field = value
        }

    fun drive(distance: Int) {
        km += distance
    }
}

class FamilyCar(year: Int, color: String) : Car(year, color) {
    override var color: String
        get() = super.color
        set(value) {
            if (value.isEmpty()) {
                throw RuntimeException("Color required")
            }
            super.color = color
        }

}