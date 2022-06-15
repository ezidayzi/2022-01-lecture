package chapter4;

/*
static 멤버를 클래스 이름으로 접근하는 사례
 */
// 같은 패키지안 동일 이름의 클래스 불가
class StaticSample2 {
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
public class Ex62_Static {
    public static void main(String[] args) {
        StaticSample.m = 10; // 10으로 변경
        StaticSample s1;
        s1 = new StaticSample();
        System.out.println(s1.m); // 10출력
        s1.f(); // 5로 변경
        StaticSample.f(); // 5로 변경
    }
}
