# Inheritance

## 상속

### **Any** 클래스

- 코틀린의 최상위 클래스는 `Any`

- 클래스에 상위타입 선언하지 않으면 `Any` 상속

  ```kotlin
  class Example1 		// 암시적인 Any 상속
  class Example2: Any // 명시적인 Any 상속
  ```

- `Any`는 `java.lang.Object` 와는 다른 클래스

  - `equals(), hashCode(), toString()` 메서드만 가지고 있음

<br>

### 상속

- 명시적으로 상위타입을 선언하려면 classheader의 콜론(:) 뒤에 상위타입 선언

  ```kotlin
  open class Base(p: Int)			// 상속을 시켜줄 클래스는 open필요
  class Derived(p: Int): Base(p)
  ```

- 자식클래스에 기본생성자가 있으면, 기본생성자에서 부모 클래스의 생성자 호출 가능

<br>

### 자식클래스가 기본생성자가 없다면

- 각각의 보조생성자에서 상위타입을 `super` 키워드를 이용해서 초기화 해주어야함

- 혹은 다른 생성자에게 상위타입을 초기화 할 수 있게 위임해야함

  ```kotlin
  class MyView: View {
      constructor(): super(1)
      constructor(ctx: Int): this()
      constructor(ctx: Int, attrs: Int): super(ctx, attrs)
  }
  ```

<br>

### Open 어노테이션

- Java의 final과 반대의 의미
- 기본적으로 코틀린의 모든 class는 final임
- open class 만이 다른 클래스가 상속할 수 있음