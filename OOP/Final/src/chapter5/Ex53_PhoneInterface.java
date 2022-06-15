package chapter5;

interface Ex53_PhoneInterface {
//    int a; // 컴파일 에러. 필드를 가질 수 없음
    int a = 10; // 가능. public static final이 생략된 형태
    public static final int TIMEOUT = 10000; // 상수 필드 public static final 생략 가능
    public abstract void sendCall(); // 추상 메소드 public abstract 생략 가능
    void recieve();
    public default void printLogo() { // default 메소드 public 생략 가능
        System.out.println("전화");
    }
}
// abstract 메소드는 꼭 구현해 주어야함. 인터페이스 내부 메소드들은 default 메소드를 제외하고는 전부 abstract 메소드들
class SamsungPhone implements Ex53_PhoneInterface {
    @Override
    public void sendCall() {

    }

    @Override
    public void recieve() {

    }

    // default 메소드는 implements 해도 되고 안해도 됨
    @Override
    public void printLogo() {

    }
}