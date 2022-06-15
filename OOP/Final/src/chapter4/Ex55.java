package chapter4;
/*
접근 지정자는 클래스 + 멤버에 지정 가능
 */
class Sample { // 클래스의 접근 지정자. 디폴트 (생략가능)와 public 만 가능
    public int a;
    private int b;
    int c;
}

public class Ex55 { // 타패키지 접근 가능
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.a = 10;
//        sample.b = 10; // 컴파일 에러. private 접근 불가
        sample.c = 10;
    }
}
