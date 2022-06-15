package chapter4;
/*
static 멤버를 객체의 멤버로 접근
 */
class StaticSample {
    public int n;

    public void g() {
        m = 20;
    }

    public void h() {
        m = 30;
    }

    public static int m; // static 변수

    public static void f() {
        m = 5;
    }
}

public class Ex60_Static {
    public static void main(String[] args) {
        StaticSample s1, s2;
        s1 = new StaticSample();
        s1.n = 5;
        s1.g(); // g()에 의해 20으로 설정됨
        s1.m = 50; // static 변수에 접근하여 50으로 설정됨
        s2 = new StaticSample();
        s2.n = 8;
        s2.h(); // h()에 의해 30으로 설정
        s2.f(); // static 함수 f에 의해 5로 설정됨
        System.out.println(s1.m);
        // 출력 결과: 5
    }
}
