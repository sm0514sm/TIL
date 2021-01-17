## Control Flow

### If else 문

Java와 거의 유사

```kotlin
var max = a
if (a < b) max = b

var max2: Int
if (a > b){
	maxa = a
}else{
	max2 = b
}
```

값이 반환되는 경우가 있다

```kotlin
// Else 반드시 필요
val max = if (a > b) a else b

// 블록의 마지막 구문이 반환
val max = if (a > b){
    print("choose a")
    a // return a
} else {
    print("choose b")
    b // return b
}
```

>   삼항연산자가 없다. if문으로 해결가능
>
>   ```
>   // Java
>   int max = (a > b) ? a : b;
>   ```

<br>

### When

`Switch`문을 대체함

```kotlin
// break 필요없음
when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    eles -> {
        print("x is neither 1 nor 2")
    }
}
// A or B 도 가능
when (x) {
    1, 2 -> print("x == 0 or x == 1")
    else -> print("otherwise")
}
// 조건문에 함수나 식 사용 가능
when (x) {
    parseInt(x) -> print("s encodes x")
    1 + 3 -> print("4")
}
```

When 또한 식으로 사용될 수 있다.

```kotlin
var res = when (x) {
    100 -> "A"
    90 -> "B"
    80 -> "C"
    else -> "F"  // 식으로 사용될 경우, else 필수
}
```

range나 collection에 in이나 !in으로 범위등을 검사가능

```kotlin
val validNumbers = listOf(3, 6, 9)
when (x){
	in validNumbers -> print("x is valid")
    in 1..10 -> print("x is 1 ~ 10")
    !in 1..10 -> print("x is not 1 ~ 10")
}
```

is 를 활용해서 타입 검사 가능

```kotlin
// 스마트 캐스트가 적용
// String일 경우, 자동으로 변환됨
fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}
```

when에 인자를 입력하지 않으면 논리연산으로 처리

```kotlin
// if else 완전 대체 가능
when {
	x.isOdd() -> print("x is odd")
    x.isEven() -> print("x is even")
    else -> print("error")
}
```

<br>

### For loops

for 문은 `iterator`를 제공하는 모든 것 반복가능

```kotlin
for (item in collection)
	print(item)

for (item in collection){
    print(item.id)
    print(item.name)
}
```

`iterator` 구현한 클래스 예제. `hasNext()`, `next()` 필요

```kotlin
fun `03_Packages_Return_and_Jumps`.main(){
    val mydata = MyData()
    for (item in mydata)
    	print(item)
}

class MyIterator {
    val data = listOf(1, 2, 3, 4, 5)
    var idx = 0
    operator fun hasNext(): Boolean {
        return data.size > idx
    }
    operator fun next(): Int {
        return data[idx++]
    }
}

class MyData {
    operator fun iterator(): MyIterator{
        return MyIterator()
    }
}
```

index를 이용하고 싶다면 indices속성 이용

```kotlin
for (i in array.indices) {
    print("$i: ${array[i]}")
}
// 둘다 사용
for ((index, value) in array.withIndex()){
    println("$index: $value")
}
```

<br>

### While loops

while, do-while 문은 자바와 거의 같음

```kotlin
// y를 여기서 선언하지 않아도 됨!!!!!! 자바랑 다른 부분
do {
	val y = retrieveData()
} while (y != null)
```

