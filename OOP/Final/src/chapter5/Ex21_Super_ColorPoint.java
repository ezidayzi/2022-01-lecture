package chapter5;

class Point21 {
    private int x, y;
    public Point21() {
        this.x = this.y = 0;
    }
    public Point21(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void showPoint() {
        System.out.println("Point21{" +
                "x=" + x +
                ", y=" + y +
                '}');
    }
}

class ColorPoint21 extends Point21 {
    private String color;
    public ColorPoint21(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }
    public void showColorPoint() {
        System.out.println(color);
        showPoint();
    }
}

public class Ex21_Super_ColorPoint {
    public static void main(String[] args) {
        ColorPoint21 cp = new ColorPoint21(5, 6, "blue");
        cp.showColorPoint();
    }
}
