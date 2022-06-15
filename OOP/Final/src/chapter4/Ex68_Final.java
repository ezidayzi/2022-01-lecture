package chapter4;
/*
final 클래스: 클래스 상속 불가
final 메소드: 오버라이딩 불가
final 필드: 상수 선언

상수 필드는 선언시에 초기값을 지정해야한다.
싱수 필드는 실행 중에 값을 변경할 수 없다.
 */
public class Ex68_Final {
    final int ROWS = 10;
    void f() {
        int[] intArray = new int [ROWS];
//        ROWS = 30; // 컴파일 오류, final 필드 값을 변경할 수 없음
    }
}
