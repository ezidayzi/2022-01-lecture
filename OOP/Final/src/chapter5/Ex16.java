package chapter5;

class A16 {
    // 컴파일러는 서브클래스의 기본 생성자에 대해 자동으로 슈퍼 클래스의 기본 생성자와 짝을 맺는다.
    public A16() {
        System.out.println("생성자 A");
    }

    public A16(int x) {
        // 생성자 오버로딩
    }
}

class B16 extends A16 {
    public B16() {
        System.out.println("생성자 B");
    }
}

public class Ex16 {
    public static void main(String[] args) {
        B16 b;
        b = new B16();
    }
}
