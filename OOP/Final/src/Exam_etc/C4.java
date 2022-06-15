package Exam_etc;

class A4 {
    void ff() {
        System.out.println("김태준");
    }
    static void tt() {
        System.out.println("남광운");
    }
}
class B4 extends A4 {
    void ff() {
        System.out.println("신정은");
    }
    void ff(int a) {
        System.out.println("오세환");
    }
    static void tt() {
        System.out.println("이도현");
    }
}
public class C4 {

    public static void main(String[] args) {
        B4 b = new B4();
        b.ff(5);
        A4 a = new B4();
        a.ff();
        b.ff();
        a.tt();
        b.tt();
    }
}
/*
오세환
신정은
신정은
남광운
이도현
 */