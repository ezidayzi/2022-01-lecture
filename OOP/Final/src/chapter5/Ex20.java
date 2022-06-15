package chapter5;

class A20 {
    public A20() {
        System.out.println("생성자A");
    }
    public A20(int x) {
        System.out.println("매개변수 생성자 A " + x);
    }
}

class B20 extends A20 {
    public B20() {
        System.out.println("생성자B");
    }

    public B20(int x) {
        super(x); // 첫 줄에 와야함
        /*
        this(); super(); --> 컴파일 에러
        super(); this(); --> 컴파일에러
        한 생성자 내부에 동시에 쓸 수 없음
         */
        System.out.println("매개변수 생성자 B " + x);
    }
}

public class Ex20 {
    public static void main(String[] args) {
        B20 b;
        b = new B20(5);
    }
}
/*

매개변수 생성자 A 5
매개변수 생성자 B 5
 */