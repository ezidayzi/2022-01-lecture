package chapter5;

class Point {
    private int x, y;
    public int a = 10;

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}
class ColorPoint extends Point {
    // 멤버의 접근 지정자와 별개로 상속은 다 받게 된다. private 의 경우소유는 하나 접근은 못함
    private int x, y; // 동일한 멤버 그대로 적어도 컴파일 에러 안남

    private String color;
    public void setColor(String color) {
        this.color = color;
    }
    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }

    public int getA() {
        a = 12;
        return a;
    }
}
public class Ex06_ColorPoint {
    public static void main(String[] args) {
        Point p = new Point();
        p.set(1, 2);
        p.showPoint();

        ColorPoint cp = new ColorPoint();
        cp.set(3, 4);
        cp.setColor("red");
        cp.showColorPoint();

        System.out.println(cp.getA());
    }
}
/* 출력 결과
(1,2)
red(3,4)
 */