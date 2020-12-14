## Basic Types

### 기본타입

코틀린에서 모든 것은 **객체** -> 모든 것에 멤버 method나 property 가능

>   자바는 primitive type과 class type으로 나뉨

![image-20201214221437013](img/01%20-%20Basic%20Types/image-20201214221437013.png)

<br>

### 숫자 Numbers

대부분은 자바와 유사하나, Java에서 숫자형이던 `char`가 코틀린에서는 문자형임

![image-20201214221726080](img/01%20-%20Basic%20Types/image-20201214221726080.png)

<br>

### 리터럴 Literal

대부분은 자바와 유사하나, 8진수 지원하지 않음

| 자료형 | 예시                           |
| ------ | ------------------------------ |
| 10진수 | 123     (Int, Short)           |
| Long   | 123L                           |
| Double | 123.5, 123.5e10                |
| Float  | 123.5f                         |
| 2진수  | 0b00001011                     |
| 8진수  | 미지원 (자바: `int ex = 017;`) |
| 16진수 | 0X0F                           |

>   **Underscores in numeric literals**
>
>   ```kotlin
>   val oneMillion = 1_000_000
>   val hexBytes = 0xFF_EC_DE_5E
>   val bytes = 0b11010010_01101101_01110011_11111111
>   ```
>
>   `_`를 이용해 표현 가능

<br>

### Representation

Java로 변환 시, 경우에 따라 숫자형이 primitive 형으로 저장되기도 하고 객체로 저장되기도 함

Nullable이나 Generic의 경우, Boxing(객체로) 저장됨

<br>

### Explicit Conversions

작은 타입(Int)는 큰 타입(Long)의 하위타입이 아님.

```kotlin
val a: Int = 1
//val b: Long = a  // Compile 오류
val b: Long = a.toLong()  // 명시적으로 변환해야함
```

<br>

### 문자 (Characters)

코틀린에서 char는 숫자 취급이 아님!

```kotlin
fun check(c: Char){
	if (c==1){		// ERROR!!
    }		
}
```

<br>

### 배열

배열은 Array 클래스로 표현.

get, set([] 연산자 오버로딩됨)

size 등 유용한 멤버 함수 포함

```kotlin
var array: Array<String> = arrayOf("코틀린", "강좌")
println(array.get(0))
println(array[0])
println(array.size)
```

#### 배열 생성

-   Array의 팩토리 함수 이용

-   arrayOf() 등의 라이브러리 함수 이용

-   ```kotlin
    val b = Array(5) { i -> i.toString() }
    val a = arrayOf("1", "2", "3", "4", "5")
    ```

#### 특별한 Array 클래스

-   Primitive 타입의 박싱 오버헤드 없애기 위함
-   intArray, ShortArray 등
-   Array를 상속한 클래스는 아니지만 Array와 같은 method, property 가짐

<br>

### 문자열

자바랑 거의 비슷

String은 characters로 구성됨

`S[i]`와 같이 접근은 가능하지만 수정은 불가

```kotlin
var str: String = "Kotlin"
println(str.get(0))
println(str[0])
println(str.length)
for (c in str){
    println(c)
}
```

#### 문자열 literal

```kotlin
val escaped = "Hello, world!\n"

val raw = """
코틀린의 raw String
엔터 "막써도" 된당
"""
```

-   Escaped String `"Kotlin"`
    -   전통적인 방식의 Java String과 유사
    -   `\`을 이용해서 escaping 처리 `\n\d\t`
-   Raw String `"""Kotlin"""`
    -   escaping 처리 필요없음
    -   개행 등 어떠한 문자 포함가능