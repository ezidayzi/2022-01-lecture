package CarFactory;

public class Car {
    private Wheel[] wheels;
    private Body body;

    public Car(Wheel[] wheels, Body body) {
        this.wheels = wheels;
        this.body = body;
        System.out.println("자동차 객체가 생성되었습니다.");
    }
}

