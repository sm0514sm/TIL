val fruits = listOf("Apple", "Banana", "Grape")

// get()보다 []를 추천함 (내부적으로 동일)
println("first's ${fruits[0]}, that's ${fruits.get(0)}")

// contains 보다 in 추천
println(fruits.contains("Apple"))
println("Apple" in fruits)

// 리스트 변경 불가
//fruits.add("Orange") // ERROR

// 대신 +로 다른 리스트에 추가로 사용
val fruits2 = fruits + "Orange"
println(fruits2)

// -로 빼는 것도 가능
val noBanana = fruits - "Banana"
println(noBanana)

val mutableFruits: MutableList<String> = mutableListOf<String>("Apple", "Banana", "Grape")
mutableFruits.add("Orange")