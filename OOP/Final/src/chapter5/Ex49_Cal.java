package chapter5;

// 추상 메소드가 없어도 abstract키워드를 붙여도 됨 (컴파일 에러안남), 객체의 생성을 막기 위해 사용
abstract class MyComponent {
    String name;
}

// 추상 메소드 (abstract method): 선언은 되어있으나 구현되어 있지 않은 메소드 를 포함한 abstract class
// abstract 키워드가 없으면 컴파일 에러
abstract class Cacluator {
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract double average(int[] a);
    public int etc() {
        return 0;
    }
}

// 추상 클래스를 상속 받으면 꼭 추상메소드를 오버라이딩 해주어야함
class GoodCalc extends Cacluator {
    @Override // annotation 안붙여도됨
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    @Override
    public double average(int[] a) {
        return 0;
    }
}

public class Ex49_Cal {
    public static void main(String[] args) {
//        MyComponent myComponent = new MyComponent(); // 컴파일 에러, 추상 클래스 객체 생성 불가
    }
}
