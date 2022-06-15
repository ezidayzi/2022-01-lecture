package Exam_2018;
interface RemoteControl {
    void turnOn();
    void turnOff();
}
public class RemoteControlApp {
    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl() {
            public void turnOn() {
                System.out.println("Turned On");
            }

            public void turnOff() {
                System.out.println("Turned Off");
            }
        };

        rc.turnOn();
        rc.turnOff();
    }
}
