# Packages, Return and Jumps

## Packages

>   **packages**: `03_Packages_Return_and_Jumps`
>
>   **files**: `[ packageTest1.kt, packageTest2.kt, packageMain.kt ]`

### Package

-   패키지 선언으로 시작됨
-   모든 컨텐츠(클래스, 함수 등)은 패키지에 포함됨
-   패키지를 명세하지 않으면 이름이 없는 기본 패키지에 포함됨.(자바와 다름)

```kotlin
package foo.bar

fun baz() {}

class Goo {}

fun `03_Packages_Return_and_Jumps`.main(args: Array<String>) {
    foo.bar.baz()
    foo.bar.Goo()
}
```



### 기본 패키지

-   아래 패키지는 기본으로  import됨

    ```
    kotlin.*
    kotlin.annotation.*
    kotlin.collections.*
    kotlin.comparisons.*
    kotlin.io.*
    kotlin.ranges.*
    kotlin.sequences.*
    kotlin.text.*
    ```


<br>

### Imports

-   필요한 package만 import하거나 rename 가능

    ```kotlin
    // foo 패키지의 Bar 클래스 import
    import foo.Bar
    
    // foo 패키지의 모든 것 import
    import foo.*
    
    // foo.Bar도 있는 경우 이름이 충돌 -> rename 으로 해결
    import bar.Bar as bBar
    ```

    

<br>

## Return and Jumps

>   **packages**: `03_Packages_Return_and_Jumps`
>
>   **files**: `[ packageTest1.kt, packageTest2.kt, packageMain.kt ]`

### 3가지 Jump 표현식

-   `return`: 함수나 익명 함수에서 반환

    ```kotlin
    fun sum(a: Int, b: Int): Int {
    	println("a: $a, b: $b")
        return a + b
    }
    ```

-   `break`: 루프를 종료시킴

    ```kotlin
    for (x in 1..10) {
        if (x > 2) {
            break
        }
        println("x: $x")
    }
    ```

-   `continue`: 루프의 다음 단계로 진행

    ```kotlin
    for (x in 1..10) {
        if (x < 2) {
            continue
        }
        println("x: $x")
    }
    ```

<br>

### Label로 break Continue

-   `식별자 + @` 형태로 사용

    ```kotlin
    myLoop@ for (i in 1..10) { 
    	println("--- i: $i ---")
        
        for (j in 1..10) {
            println("j: $j")
            if (i + j > 12) {
                break@myLoop
            }
        }
    } 
    ```

<br>

### 중첩의 요소들

-   함수 리터럴, 지역함수, 객체 표현식, 함수는 중첩 가능

    ```kotlin
    /* 중첩 함수 */
    fun foo() {
        var ints = listOf(0, 1, 2, 3)
        
        ints.forEach(fun(value: Int) {
            if (value == 1) return // 1일때만 종료되고 나머지는 각각
            print("$value ")
        })
    }
    // result => 0 2 3
    
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
    
        ints.forEach lambda@ {
            if (it == 1) return@lambda
            print("$it ")
        }
    }
    // return => 0 2 3
    ```

<br>

### 암시적 레이블

-   람다식에서만 `return`이 필요한 경우, label해야하는데 이것이 귀찮으면 람다가 사용된 함수의 이름을 사용!

    ```kotlin
    /* 암시적 레이블 람다식 */
    fun foo4() {
        val ints = listOf(0, 1, 2, 3)
    
        ints.forEach {
            if (it == 1) return@forEach // 암시적 레이블
            print("$it ")
        }
    }
    // return => 0 2 3
    ```

