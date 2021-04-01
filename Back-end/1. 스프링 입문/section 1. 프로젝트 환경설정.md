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

## View 환경설정

## 빌드하고 실행하기

