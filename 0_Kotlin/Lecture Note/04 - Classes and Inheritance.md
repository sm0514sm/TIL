# Classes and Inheritance

## 클래스

### 클래스 선언

-   `class` 키워드로 선언

    -   클래스 이름
    -   클래스 헤더 (매개변수, 기본 생성자 등)
    -   클래스 바디 (중괄호 `{}`)

    ```kotlin
    class Invoice(data: Int){
    }
    ```

    >   헤더와 바디는 옵션 (모두 생략 가능)
    >
    >   ```kotlin
    >   class Empty
    >   ```

<br>

### 기본생성자

-   클래스 별로 1개만 가질 수 있음

-   클래스 헤더의 일부

-   `constructor`를 이용함. (어노테이션, 접근지정자 없을 땐 생략가능)

    ```kotlin
    class Person constructor(firstName: String) {}
    class Person2 (firstName: String) {}
    ```

-   초기화는 `init` 블록 안에서 수행

    ```kotlin
    class Customer(name: String) {
    	init { 
        	logger.info("testests Customer value ${name}")
        }
    }
    ```

-   멤버 변수(property) 설정 불필요함

    ```kotlin
    class Customer1(name: String) {
    	val name = name
        // ...
    }
    class Customer2(val name: String) {
        // ...
    }
    ```

    ```kotlin
    class Customer1(name: String) {
    	var name: String = name
        init {
            println("이름: $name")
        }
    }
    
    class Customer2(var name: String) {
        init {
            println("이름: $name")
        }
    }
    
    fun main() {
        val customer1 = Customer1("상민")
        val customer2 = Customer2("상민")
        println(customer1)
        println(customer2)
        
        // getter setter 필요없음
        customer1.name = "코틀린 상민"
        customer2.name = "코틀린 상민"
        println(customer1.name)
        println(customer2.name)
    }
    ```

<br>

### 보조생성자

-   클래스 별로 여러개를 가질 수 있음

-   클래스의 body에 선언

-   `constructor` 키워드로 선언

    ```kotlin
    class Person{
    	constructor(name: String) {
            //...
        }
    }
    ```

-   기본생성자를 가지고 있다면 모든 보조생성자는 기본생성자를 직접 or 간접적으로 위임해야함

    -   `this` 키워드 이용함
        -   직접: 기본생성자에 위임
        -   간접: 다른 보조생성자에 위임

    ```kotlin
    class Person(val name: String) { // 기본생성자 가짐
    	constructor (name: String, parent: Person): this(name){ // 직접
            //...
        }
        constructor (): this("홍길동", Person()){ //간접
            //...
        }
    }
    ```

<br>

### Generated 기본생성자

-   기본생성자, 보조생성자를 선언하지 않으면 generated 기본생정사가 만들어짐

-   generated primary constructor (public, 매개변수 X)

-   변경하려면 아래처럼 빈 기본생성자 선언

    ```kotlin
    class DontCreateMe private constructor() {
    	//...
    }
    ```

<br>

### 인스턴스 생성

-   `new` 키워드가 없기 때문에 생성자를 일반 함수처럼 호출

    ```kotlin
    val invoice = invoice()
    ```



