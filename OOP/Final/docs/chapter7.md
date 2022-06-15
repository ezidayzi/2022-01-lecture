# 제네릭과 컬렉션
### 컬렉션(collection) 의 개념
- 컬렉션 = 요소 객체들의 저장소
- 자바의 collectioon 인터페이스 (java.util)
  -> 자바에서 collection을 구현하는 클래스들 전부

### 컬렉션을 위한 자바 인터페이스와 클래스
- Collection<E> 인터페이스
- Set<E>: 순서X 중복X
- List<E>: 순서O 중복O
- Queue<E>: FIFO


### 제네릭을 왜 사용하는가?
- 컴파일 시간에서의 강한 타입 체크
- 캐스트의 제거

```java
import java.util.ArrayList;

class Ex {
    public static void main(String[] args) {
        // 예전 스타일 -> 다른 타입 들어와도 컴파일 에러가 나지 않음
        List list = new ArrayList();
        list.add("Hello");
        list.add(1);
        String s = (String) list.get(0); // 강제 형변환안해주면 컴파일 에남
        // 요소 조회
        
        List<String> list = new ArrayList<String>();
        list.add("hello");
        String s = list.get(0); // cast 필요 없음
    }
}
```

### 제네릭 타입
- 타입 매개변수를 갖는 class 혹은 interface

