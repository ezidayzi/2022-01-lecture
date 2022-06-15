package chapter5;

class A { // 디폴트 클래스는 다른 패키지에서 접근할 수 없음, public 클래스여야 import 가능
    private int a; // 자신의 클래스 내부
    int b; // 패키지 내에서 가능
    protected int c; // 다른 패키지여도 자식이면 접근 가능함
    public int d; // 다른 모든 클래스에 접근 허용
}

class B extends A {
    void set() {
        b = 1;
        c = 2;
        d = 3;
//        a = 0; // private 키워드는 자신의 클래스에서만 가능함
    }
}

public class Ex11 {
}
