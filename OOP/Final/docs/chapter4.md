### 4장 클래스와 객체
# 4장 클래스와 객체

## 객체지향의 특성

### 추상화 abstract

: 실세계의 대상이 가지고 있는 것 중 필요한 것만 추상화 하여 함수(행동)와 변수(특성)으로 나타낸 것

### 캡슐화 encapsulation

: 객체를 캡슐로 싸서 내부를 볼 수 없게 하는 것

캡슐 = 변수 + 함수

내부를 볼 수 없게 = 접근 지정자 (public, private)

### 상속 inheritance

: 상위 개체의 속성이 하위 개체에 물려짐

→ 자식 클래스가 부모 클래스의 속성을 물려받고 기능을 확장시키는 것

- 부모 클래스: 슈퍼 클래스
- 하위 클래스: 서브 클래스

### 다형성 polymorphism

- 메소드 오버로딩: 같은 이름이지만 다르게 작동
- 메소드 오버라이딩: 슈퍼클래스의 메소드를 서브 클래스마다 다르게 구현

### 객체 지향 언어의 목적

- 소프트웨어의 생산성 향상
    - 컴퓨터 산업 발전에 따라 소프트웨어의 생명 주기 단축
- 객체지향 언어
    - 상속, 다형성, 객체, 캡슐화 등 소프트웨어 재사용을 위한 여러 장치 내장

      → 소프트웨어 재사용과 부분 수정이 빠름

- 실세계에 대한 쉬운 모델링

### 절차지향 프로그래밍과 객체지향 프로그래밍

결국엔 프로그램의 관점(패러다임)차이가 문법에 반연된것

= 도구에 의해서 영향 → 사고 방식에 영향 → 객체 vs 절차 관점의 차이가 소스코드상에서 차이로 나타남

즉 소스코드의 놀음이므로 어떻게 작성되었는가에 대한 소스코드 스타일에 영향.

***객체지향 프로그래밍***

- 우리가 세상을 바라보는 시선 = 객체(대상) 식별
- 실세계 파악과 코딩 사이의 왜곡이 없음

  = 인간이 실세계를 파악하는 관점과 코딩이 동일함


<aside>
📌 객체들간의 상호 작용으로 표현 (객체간의 의사소통)
클래스 혹은 객체들의 집합으로 프로그램 작성
*문제상황 → 객체 파악 → 함수 & 변수 추출 (abstraction) 
프로그램 = 함수 변수*

</aside>

***절차지향 프로그래밍***

- 실행될 명령어를 순서대로 나열
- 인간이 실세계를 파악하는 것과 컴퓨터 관점이 다르다
- 직관적이지 않으며 이는 코드 생산성에 영향을 미친다.

### 클래스와 객체

- 클래스 = 타입
    - 객체를 만들어내기 위한 설계도 혹은 틀
    - 객체의 속성과 행동 포함
- 객체
    - 클래스의 모양 그대로 찍어낸 실체
    - object, 그 타입의 사례 = instance
    - 메모리 공간을 갖는 구체적인 실체

  → 객체는 heap에 정의 된다


```
stack >> 지역 변수
text/code >> class가 위치함
class 단위로 로딩한다 = 번역
>> 필요 시점이 되면 text 영역에 올아오게됨 
```

> 객체지향으로 프로그래밍을 짠다 =  실행시간에 메모리에 객체를 대응시킨다.
클래스는 목적을 달성하기 위한 수단이므로 클래스 지향이라는 말은 옳지 않다.
>

### 클래스 구성

필드(변수) + 메소드 (함수)

### 객체의 생성과 접근

```java
public class Circle {
    public int radius;
    public String name;

    public Circle() {};

    public double getArea() {
        return 3.14 * radius*radius;
    }
}
```

1) 레퍼런스 변수 선언

```java
Circle pizza;
```

2) 객체 생성 - new 연산자 이용

```java
pizza = new Circle();
```

3)  객체 멤버 접근 - . (점) 연산자 이용

```java
pizza.radius = 10;
pizza.name = "자바피자"

double area = pizza.getArea();
```

```java
package chapter4;

public class Circle {
    public int radius;
    public String name;

    public Circle() {};

    public double getArea() {
        return 3.14 * radius*radius;
    }

    public static void main(String[] args) {
        Circle pizza;
        // pizza 지역 변수 선언 -> 초기화 없이 접근시 컴파일에러

        pizza = new Circle();
        System.out.println(pizza.name); // null
        System.out.println(pizza.radius); // 0

        pizza.radius = 10;
        pizza.name = "자바피자";
        double area = pizza.getArea();
        System.out.println(pizza.name+"의 면적은 "+area);

        Circle donut;
        donut = new Circle();
        donut.radius = 11;
        donut.name = "자바 도넛";
        area = donut.getArea();
        System.out.println(donut.name+"의 면적은 "+area);
    }
}
```

### 생성자

: 객체가 생성될 때 초기화를 위해 실행되는 메소드

- 생성자는 메소드
- 생성자 이름은 클래스 이름과 반드시 동일함
- 생성자 여러개 작성 가능(오버로딩, 멤버 이름은 같은데 파라미터가 다름)
- 생성자는 new를 통해 객체를 생성할 때, 객체당 한번 호출
- 생성자는 리턴타입 지정 불가
- 생성자의 목적은 객체 초기화
- 생성자는 객체가 생성될 때 반드시 호출됨

  → 그러므로 하나 이상 선언되어야함

  → ***개발자가 생성자를 작성하지 않았으면 컴파일러가 자동으로 기본 생성자를 삽입***

  → ***개발자가 클래스에 생성자를 하나라도 작성한 경우에는 기본 생성자가 자동 삽입 되지 않음을 주의***


### this

- 객체의 멤버 변수와 메소드 변수의 이름이 같은 경우
- 다른 메소드 호출 시 객체 자신의 레퍼런스를 전달할 때
- 메소드가 객체 자신의 레퍼런스를 반환할 때

```java
package chapter4;

public class Book {
    String title;
    String author;

    public Book(String title) {
        this.title = title;
        this.author = "작자미상";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        Book litlePrince = new Book("어린왕자", "생택쥐베리");
        Book loveStory = new Book("춘향전");

				Book book = new Book();// 컴파일 에러

        System.out.println(litlePrince.title+ " "+litlePrince.author);
        System.out.println(loveStory.title+" "+loveStory.author);
    }
}
```

### this()로 다른 생성자 호출

- 클래스 내의 다른 생성자 호출
- 생성자 내에서만 사용 가능
- *반드시 생성자 코드의 제일 처음에 수행*

  → 생성자의 첫번째 문장이 아니면 컴파일 오류


### 객체의 치환

<aside>
📌 객체가 복사되는 것이 아니며 레퍼런스가 복사된다.
→ **같은 것을 가리키게 된다.**

</aside>

### 인자 전달

1) 기본 타입의 값 전달 (primitive)

: 값이 복사되어 전달

→ 실인자 값은 변경되지 않음

2) 객체 혹은 배열 전달 (reference)

: 객체나 배열의 레퍼런스만 전달 (주소전달)

→ 객체 혹은 배열이 통째로 복사되어 전달되는 것은 아님

→ 메소드의 매개변수와 호출한 실인자 객체나 배열 공유

### 메소드 오버로딩

- 이름이 같은 메소드를 작성
- 매개변수의 순서 고려함, 리턴타입은 오버로딩과 관련 없음

  `getSum(int a, double b)`

  `getSum(double a, int b)`

  → 오버로딩 가능


<aside>
📌 주의사항
정수: int, 실수: double 기본형임을 잊지말자..
ex) getSum(1, 1.1) → int, double로 판단됨
</aside>

### 객체의 소멸과 가비지 컬렉션

- 객체 소멸

  : new에 의해 할당된 객체 메모리를 자바가상기계의 가용 메모리로 되돌려 주는 행위

- 자바 응용프로그램에서 임의로 객체 소멸 할 수 없음
    - 객체 소멸은 자바 가상 기계의 고유한 역할
    - 자바 개발자에게는 매우 다행스러운 기능
- **가비지**

  : **가리키는 레퍼런스가 하나도 없는 객체**

- 가비지 컬렉션

  : 자바 가상 기계의 가비지 컬렉터가 자동으로 가비지를 수집, 반환


### 가비지의 발생

: null 할당시 가비지됨 (어떠한 변수도 자신을 참조하지 않고 쓰레기 데이터가됨)

### 가비지 컬렉션

- 자바에서 가비지를 자동 회수하는 과정
- 개발자에 의한 강제 가비지 컬렉션 `System.gc();` → 가비지 컬렉션 자동 요철
  → 받아드릴지 말지는 가비지 컬렉션이 판단

### 점근 지정자
- private, protected, public, 디폴트(접근 지정자 생략 가능)
- private: 외부로부터 완벽 차단 (선언된 클래스 내부에서만)
- default: 동일 패키지에 허용 (접근 지정자 생략)
- protected: 동일 패키지와 자식 클래스에 허용 (상속)
- public: 모든 클래스에 허용

***클래스접근지정***
: public, 디폴트만 가능

### static 멤버와 non-static 멤버
- static = 클래스꺼 (타입꺼)
- non-staatic = 객체꺼
- 멤버 = 함수 + 필드, 클래스안 클래스 --> static 가능함
- -> 생성자에는 쓸 일이 없다.
- 