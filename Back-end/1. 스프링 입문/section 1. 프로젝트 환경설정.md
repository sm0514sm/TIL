## 프로젝트 생성

> **스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성**
>
> https://start.spring.io

### 프로젝트 선택

![image-20210401230040002](img/section%201.%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC/image-20210401230040002.png)

- Project: `Gradle` (최근엔 Gradle 많이 사용)
- Languages: `Java`
- Spring Boot: SNAPSHOP, M123 없는 가장 최신 버전 선택
- Project Metadata
    - Group: hello
    - artifactId: hello-spring
- **Dependencies**: Spring Web, Thymeleaf (html 만들어주는 템플릿 엔진)



### build.gradle

```java
// 설정한 내역
plugins {
	id 'org.springframework.boot' version '2.4.4'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
}

// 제작하는 버전
group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

// 공개된 사이트로부터 라이브러리 다운 받아라
repositories {
	mavenCentral()
}

// 추가한 라이브러리
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}

```

### build 설정 바꾸기

![image-20210401231503178](img/section%201.%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC/image-20210401231503178.png)

gradle -> IntelliJ IDEA로 바꿔야 속도가 더 빠름



## 라이브러리 살펴보기

> `External Libraries`
>
> Gradle은 의존관계가 있는 라이브러리를 함께 다운로드

Command 2번 누르면 테두리 메뉴에서 Gradle를 들어감

<img src="img/section%201.%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8C%E1%85%A6%E1%86%A8%E1%84%90%E1%85%B3%20%E1%84%92%E1%85%AA%E1%86%AB%E1%84%80%E1%85%A7%E1%86%BC%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC/image-20210401233030222.png" alt="image-20210401233030222" style="zoom: 50%;" />

### **스프링 부트 라이브러리**

- spring-boot-starter-web 
    - **spring-boot-starter-tomcat: 톰캣 (웹서버)** 
    - **spring-webmvc: 스프링 웹 MVC**
- spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View) 
- spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
    - spring-boot 
        - spring-core
    - spring-boot-starter-logging 
        - logback, slf4j

### **테스트 라이브러리**

- spring-boot-starter-test
    - junit: 테스트 프레임워크
    - mockito: 목 라이브러리
    - assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리 
    - spring-test: 스프링 통합 테스트 지원



## View 환경설정



## 빌드하고 실행하기



