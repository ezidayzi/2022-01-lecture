# 6장 모듈과 패키지 개념, 자바 기본 패키지
### 디렉토리로 각 개발자의 코드 관리 (패키지)
여러 패키지 같은 클래스으이 이름 같음
(따지고 보면 클래스 이름이 같은 것은 아님)
이름은 같지만 경로명이 달라 다른 파일로 취급함

## 모듈과 패키지?
- 패키지: 서로 관련된 클래스와 인터페이스의 컴파일 된 클래스 파일들을 하나의 디렉토리에 묶어 놓은 것
- 모듈: 여러 패키지와 이미지 등을 모아 놓은 컨테이너로 응용 프로그램 역시 여러개의 모듈들로 분할하여 작성이 가능함

### 패키지 사용하기 import 문
```java
public class ImportExample {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
    }
}
```
import 문 작성하는 이유
1) import 하지 않으면 풀네임 작성해야함 
2) 다른 패키지에 scanner가 또 있는 경우 여러개를 사용하기 위해 명시

```java
import java.util.Scanner;
import java.util.*;
```
* -> util 패키지 내의 모든 클래스 포함

## 모듈 개념
- 자바 9에서 도입된 개념
- 패키지와 이미지 등의 리소스를 담은 컨테이너
- .jmod로 저장됨.

### 주요 패키지
- java.lang
: 자바의 language 패키지
- 자동으로 import 됨. import문 필요없다.

### Object
: 자바에서의 최상위 클래스
- java.lang 패키지에 포함됨
- 모든 클래스의 슈퍼 클래스임
- 모든 클래스에 강제 상속, 모든 객체가 공통으로 가지는 객체의 속성을 나타내는 메소드 보유

**주요 메소드**
- boolean equals(Object obj): obj가 가리키는 객체와 객체를 비교하여 같으면 true 리턴
- Class getClass(): 현 객체의 런타임 클래스를 리턴
- int hashCode(): 현 객체에 대한 해시코드 값을 리턴
- String toString(): 현 객체에 대한 문자열 표현을 리턴

**_해시함수_**
: 최대한 분산시키려 하는 함수 (겹치지 않도록)

**해시코드**
: 자바의 모든 객체는 해시코드를 가지고 있다 
= 다 다를 수 없다.
object의 개수가 int의 범위를 넘어가면 같아질 가능성이 있다.

### 객체를 문자열로 변환
**toString()**
- 객체를 문자열로 반환
- Object 클래스에 구현된 toString()이 반환하는 문자열
- `객체+문자열` -> `객체.toString()+문자열` 자동 반 

### 객체 비교와 equals()
**== 연산자**
- 두 개의 레퍼런스 비교 (같은 대상을 가리키고 있니 비교)

**boolean equals(Object obj)**
- 객체 내용이 같은지 비교

### Wrapper 클래스
- 자바의 기본 타입을 클래스화한 8개 클래스
- 이름이 Wrapper인 클래스는 존재하지 않음
- 용도: 기본 타입의 값을 객체로 다룰 수 있게 함


**기본 타입의 값으로 Wrapper 객체 생성**
```java
class Ex {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(10);
        Character c = Character.valueOf("c");
        Double f = Double.valueOf(3.14);
        Boolean b = Boolean.valueOf(true);
    }
}
```
**문자열로 Wrapper 객체 생성**
```java
class Ex {
    public static void main(String[] args) {
        Integer i = Integer.valueOf("10");
        Character c = Character.valueOf("c");
        Double f = Double.valueOf("3.14");
        Boolean b = Boolean.valueOf("true");
    }
}
```
+) Java9부터 생성자를 이용한 Wrapper 객체 생성을 폐기했다.

**주요메소드**
- Wrapper 객체들은 거의 유사, 많은 메소드가 static 타입
- Integer 클래스의 주요 메소드

### 박싱과 언박싱
- 박싱: 기본 타입의 값을 Wrapper 객체로 변환
- 언박싱: Wrapper 객체에 들어있는 기본 타입의 값을 빼내는 것
- 자동 박싱과 언박싱 -> JDK1.5부터
`Integer ten = 10;` 자동 박싱 `Integer i = Integer.valueOf(10);`
`int n = ten;` 자동 언박싱 `int n = ten.intValue();`

### String의 특징과 객체 생성
- String: java.lang.String
String 클래스는 하나의 문자열을 표현
- immutable하다

### 스트링 리터럴과 new String()
- 스트링 생성 방법
1) 리터럴로 생성, String s = "Hello";
- JVM이 리터럴 관리, 응용프로그램 내에서 공유됨

2) String 객체로 생성, String t = new String("Hello");
- 힙 메모리에 String 객체 생성

### 문자열 비교
**int compareTo(String anotherString)**
- 문자열이 같으면 0리턴
- 이 문자열이 anotherString 보다 사전에 먼저 나오면 음수 리턴
- 이 문자열이 anotherString 보다 사전에 나중에 나오면 양수 리턴
`==` 는 문자열 비교에는 사용하면 안됨

### String Buffer클래스
- 가변 크기의 문자열 저장클래스
- String 클래스와 달리 문자열 변경이 가능하다.
- String Builder와 메소드의 이름과 역할이 동일함 but String Builder는 동기화를 제공하지 않는다.
