package chapter4;

public class Ex65_Static {
    int n;
    void f1(int x) {n=x;} // 정상

    static int m;
    /*
    static void s1(int x) {n = x;}
    static void s2(int x) {f1(3)};
     */
    // 컴파일 오류 - static 메소드는 this 객체에 접근 할 수 없음

    static void s3(int x) {m=x;}
    static void s4(int x) {s3(3);}
    // 정상 - static 메소드는 static 필드 및 메소드 호출 가능
}
