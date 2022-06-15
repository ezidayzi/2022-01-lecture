package conceptsOfCollection;

import java.util.HashSet;
import java.util.Objects;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /*
    객체의 중복을 제거하기 위해서는 equals 와 hashCode 오버라이딩 해야함
     */
    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        if (x == p.x && y == p.y) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Circle {
    Point center;
    int radius;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Circle c = (Circle) obj;
        if (center.equals(c.center)&&radius==c.radius)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        // center 객체(레퍼런스) 의 hashcode 호출
        // radius 는 primitive
        return Objects.hash(center, radius);
    }
}

public class Ex08 {
    public static void main(String[] args) {
        HashSet<Point> set = new HashSet<>();
        set.add(new Point(1, 2));
        set.add(new Point(1, 2));
        set.add(new Point(3, 4));
        set.add(new Point(4, 5));
        set.add(new Point(5, 6));

        System.out.println("size: "+set.size());

        for (Point p: set)
            System.out.println(p.toString()+"\t");

        HashSet<Circle> set2 = new HashSet<>();
        set2.add(new Circle(new Point(1, 3), 2));
        set2.add(new Circle(new Point(2, 3), 2));
        set2.add(new Circle(new Point(2, 3), 2));
        set2.add(new Circle(new Point(4, 3), 2));
        set2.add(new Circle(new Point(5, 3), 2));

        for (Circle c: set2)
            System.out.println(c.toString()+"\t");

    }
}
