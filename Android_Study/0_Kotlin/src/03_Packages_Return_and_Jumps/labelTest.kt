package `03_Packages_Return_and_Jumps`

import test.printOther1

fun main() {
    myLoop@ for (i in 1..10) {
        println("--- i: $i ---")

        for (j in 1..10) {
            println("j: $j")
            if (i + j >= 15) {
                break@myLoop
            }
        }
    }
}