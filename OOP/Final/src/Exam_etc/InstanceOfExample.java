package Exam_etc;

class A {
}
class B extends A { }
class C extends B { }
class D extends B { }
class E extends A { }

public class InstanceOfExample {
    public static void main(String[] args) {
        A t = new A();
        A f = new B();
        A k = new C();
        A l = new D();
        A x = new E();
        if (t instanceof A)
            System.out.print("♥");
        if (t instanceof B)
            System.out.print("왜");
        if (f instanceof C)
            System.out.print("즐");
        if (k instanceof A)
            System.out.print("사스가");
        if (l instanceof B)
            System.out.print("갓");
        if (l instanceof E)
            System.out.print("어렵냐ᄏᄏ");
        if (x instanceof B)
            System.out.print("헷갈림?ᄏᄏ");
        if (x instanceof A)
            System.out.print("?");
        if (f instanceof Object)
            System.out.print("♥");
    }
}
/*
♥사스가갓?♥
 */