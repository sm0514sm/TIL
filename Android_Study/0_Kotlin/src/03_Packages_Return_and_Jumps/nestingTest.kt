package `03_Packages_Return_and_Jumps`

/* 중첩 함수 */
fun foo() {
    val ints = listOf(0, 1, 2, 3)

    ints.forEach(fun(value: Int) {
        if (value == 1) return // 1일때만 종료되고 나머지는 각각
        print("$value ")
    })
}
// result => 0 2 3 End

/* 람다식 주의!! */
fun foo2() {
    val ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if (it == 1) return
        print("$it ")
    }
}
// return => 0

/* 람다식 라벨링 */
fun foo3() {
    val ints = listOf(0, 1, 2, 3)

    ints.forEach lambda@{
        if (it == 1) return@lambda
        print("$it ")
    }
}
// return => 0

/* 암시적 레이블 람다식 */
fun foo4() {
    val ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if (it == 1) return@forEach // 암시적 레이블
        print("$it ")
    }
}
// return => 0 2 3

fun main() {
    foo()
    println("end")
    foo2()
    println("end")
    foo3()
    println("end")
    foo4()
    println("end")
}