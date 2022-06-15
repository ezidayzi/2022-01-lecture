package conceptsOfInterface;

import java.net.InterfaceAddress;

/*
Interface
Constant variable
Abstract method
Default method
Static method
Private method
Private Static Method
 */
// 추상 메소드를 포함하고 있는 인터페이스 => 명세 껍데기
// 인터페이스도 타입이라고 이해하자
interface Interface {
    /*
    추상메서드 이므로 무조건 overriding 해줘야함. 안해주면 컴파일에러임
    default 메서드를 추가한 이유가 되기도 함.
    */
    void method();

    // 구현부가 있는 메서드 (인터페이스 안에)
    default void newDefaultMethod() {
        System.out.println("newDefaultMethod() in interface");
    }

    // Static Method
    static void staticMethod() {
        System.out.println("staticMethod() in interface"); // 타입이름으로 접근 하여 사용가능
    }


//    private void privateAbstractMethod(); // 불가, 컴파일 에러
//    private default void privateDefaultMethod() {} //불가 , 컴파일 에러
    default void defaultMethod1() {
        privateMethod1();
    }

    default void defaultMethod2() {
        System.out.println("Default Method in Interface");
    }

    // Private Method
    private void privateMethod1() {
        System.out.println("Private Method1 in Interface");
        privateMethod2();
        defaultMethod2();
        method();
        staticMethod2();
        privateStaticMethod2();
        /*
        전부가능? ㄷ ㄷ
         */
    }

    private void privateMethod2() {
        System.out.println("Private Method2 in Interface");

    }

    static void staticMethod2() {
        privateStaticMethod1();
    }

    // Private Static Method
    private static void privateStaticMethod1() {
        // static method 들만 호출 가능함
    }
    private static void privateStaticMethod2() {
        privateStaticMethod1();
    }
}

// 인터페이스끼리의 상속 가능 -> 추상메서드 이름 겹쳐도 에러 안남
interface SubInterface extends Interface {
    void method();

    @Override // 상위 타입의 메서드 오버라이드
    default void newDefaultMethod() {
        System.out.println("newDefaultMethod() in SubInterface");
    }
}

class Cls implements Interface {
    @Override // 오버라이드 (하위에서 재정의)
    public void method() {
        System.out.println("method() in Cls");
    }

    @Override // 인터페이스의 default 메서드 오버라이딩 가능
    public void newDefaultMethod() {
        Interface.super.newDefaultMethod(); // 인터페이스 이름.super로 상위 메서드 접근
        /*
        추상메서드 super -> 에러
        구체메서드 super -> 가능
         */
        System.out.println("newDefaultMethod() in interface");
    }
}

class Cls2 implements SubInterface {
    @Override
    public void method() {
        /*
        Interface.super.newDefaultMethod(); // 컴파일에러
        건너뛰기 할 수 없음
         */
        SubInterface.super.newDefaultMethod(); // 가능
        System.out.println("method() in Cls2");
    }
}

class SuperCls {
    public void newDefaultMethod() {
        System.out.println("newDefaultMethod() in SuperCls");
    }
}

class Cls3 extends SuperCls implements Interface {
    @Override
    public void method() {
        System.out.println("method() in Cls3");
    }
}

interface AnotherInterface {
//    void newDefaultMethod(); // 추상메서드는 구현하지 않으면 에러
    default void newDefaultMethod() {
        System.out.println("newDefaultMethod() in AnotherInterface");
    }
}

class Cls4 implements Interface, AnotherInterface {
    @Override
    public void method() {
        System.out.println("method() in Cls4");
    }

    @Override // 오버라이드 & 구현한 효과
    public void newDefaultMethod() {
        Interface.super.newDefaultMethod();
        AnotherInterface.super.newDefaultMethod();
        System.out.println("newDefaultMethod() in Cls4");
    }
    /*
    AnotherInterface의 newDefaultMethod가 default 메서드이고
    Interface의 newDefaultMethod 또한 default 메서드이면
    default라 할지라도 오버라이딩 해주어야한다.
     */
}

// 추상 메소드를 가진 추상 클래스
abstract class AbstractClass {
    abstract void newDefaultMethod(); // 구현해주지 않으면 에러
}

class Cls5 extends AbstractClass implements Interface {
    @Override
    public void method() {
        System.out.println("method() in Cls5");
    }

    @Override
    public void newDefaultMethod() {
        System.out.println("newDefaultMethod() in Cls5");
    }
}

    public class InterfaceEx {
    public static void main(String[] args) {
        Cls obj = new Cls();
        obj.method();
        obj.newDefaultMethod();

        Interface obj2 = new Cls(); // 인터페이스는 타입으로 취급 가능함
        obj2.method();
        obj2.newDefaultMethod();

        System.out.println("================================");
        Cls2 obj3 = new Cls2();
        obj3.method();
        obj3.newDefaultMethod();
        /*
        SubInterface는 Interface를 상속 받았기 때문에 SubInterface와 Interface로 SubInterface타입의 객체를 가리킬 수 있다.
         */
        SubInterface obj4 = new Cls2();
        obj4.method();
        obj4.newDefaultMethod();

        Interface obj5 = new Cls2();
        obj5.method();
        obj5.newDefaultMethod();

        System.out.println("================================");
        /*
        인터페이스와 부모 클래스에 이름이 동일한 메서드가 존재하면 클래스에 우선순위를 둔다.
         */
        Cls3 obj6 = new Cls3();
        obj6.method();
        obj6.newDefaultMethod();

        Interface obj7 = new Cls3();
        obj7.method();
        obj7.newDefaultMethod();

        System.out.println("================================");
        /*
        A 인터페이스의 default 메소드와 B 인터페이스의 추상메소드의 이름이 동일한 경우
         */
        Cls4 obj8 = new Cls4();
        obj8.method();
        obj8.newDefaultMethod();

        Interface obj9 = new Cls4();
        obj9.method();
        obj9.newDefaultMethod();

        System.out.println("================================");
        /*
        추상 클래스를 상속받고 인터페이스를 동시에 구현한 경우
         */
        Cls5 obj10 = new Cls5();
        obj10.method();
        obj10.newDefaultMethod();

        Interface obj11 = new Cls5();
        obj11.method();
        obj11.newDefaultMethod();

        /*
        인터페이스의 static 메소드
         */
        Interface.staticMethod();
        // obj11.staticMethod(); // 컴파일에러


    }
}
/*
method() in Cls
newDefaultMethod() in interface
 */