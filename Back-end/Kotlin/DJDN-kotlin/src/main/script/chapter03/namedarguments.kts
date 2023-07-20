fun createPerson(name: String, age: Int = 1, height: Int, weight: Int) {
    println("$name $age $height $weight")
}

createPerson("jake", 12, 152, 43) // 알기 어려움
createPerson(name = "jake", age = 12, weight = 43, height = 152) // 가독성 향상
createPerson("jake", age = 12, weight = 43, height = 152) // 위치 기반 이후 명시적 아규먼트 선택적 사용
createPerson("jake", weight = 43, height = 152) // 위치 기반 이후 명시적 아규먼트 선택적 사용

