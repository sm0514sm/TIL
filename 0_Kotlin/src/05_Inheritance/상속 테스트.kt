package `05_Inheritance`

//class AA      // 상속 불가한 클래스
//class BB : AA // 에러 발생

open class AA // 상속 가능한 클래스
class BB : AA()

open class AA2 (x: Int)
class BB2(x: Int): AA2(x)
