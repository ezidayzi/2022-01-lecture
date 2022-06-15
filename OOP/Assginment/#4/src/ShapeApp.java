interface Shape {
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 "+radius+"인 원입니다.");
    }

    @Override
    public double getArea() {
        return radius*radius*PI;
    }

    @Override
    public void redraw() {
        Shape.super.redraw();
    }
}

class Oval implements Shape {
    private final int width;
    private final int height;

    Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width+"X"+height+"에 내접하는 타원입니다.");
    }

    @Override
    public double getArea() {
        double x = width/2.0;
        double y = height/2.0;
        return x*y*PI;
    }

    @Override
    public void redraw() {
        Shape.super.redraw();
    }
}

class Rect implements Shape {
    private final int width;
    private final int height;

    Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width+"X"+height+"크기의 사각형입니다.");
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public void redraw() {
        Shape.super.redraw();
    }
}


public class ShapeApp {
    public static void main(String[] args) {
        Shape[] list = new Shape[3];
        list[0] = new Circle(10);
        list[1] = new Oval(20, 30);
        list[2] = new Rect(10, 40);

        for(Shape shape: list) {
            shape.redraw();
        }

        for(Shape shape: list) {
            System.out.println("면적은 " + shape.getArea());
        }
    }
}
