fun getFullName() = Triple("Jo", "jojo", "jujuuu")

// 귀찮은 구조분해
val result = getFullName()
val first = result.first
val middle = result.second
val last = result.third
println("$first $middle $last")

// 간편한 구조분해
val (first2, middle2, last2) = getFullName()
println("$first2 $middle2 $last2")

// 1개가 필요없을때
val (first3, _, last3) = getFullName()
println("$first3 $last3")

// 특정 포지션 이후 할당 필요 없으면 _도 생략가능
val (_, middle4) = getFullName()
println("$middle4")
