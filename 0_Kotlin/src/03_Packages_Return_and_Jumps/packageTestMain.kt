package `03_Packages_Return_and_Jumps`

import printOther2
import test.printOther1

fun main() {
    printOther1()
    printOther2()

    val a = listOf(1, 2, 3) // listOf 는 kotlin.collections 에 포함되어 있지만 안해도 됨
    println(a)
}