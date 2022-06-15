package chapter5;

class A14 {
    public A14() {
        System.out.println("생성자 A");
    }
}

class B14 extends A14 {
    public B14() {
        System.out.println("생성자 B");
    }
}

class C14 extends B14 {
    public C14() {
        System.out.println("생성자 C");
    }
}

public class Ex14_Super_Sub {
    public static void main(String[] args) {
        C14 c;
        c = new C14();
    }
}
/*
호출 순서 C -> B -> A
실행 순서 A -> B -> C
생성자 A
생성자 B
생성자 C
 */