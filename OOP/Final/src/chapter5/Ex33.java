package chapter5;

class Shape { // 슈퍼 클래스
    public Shape next;

    protected String name;

    public Shape() {next = null;}

    public void paint() {
        draw();
    }

    public void draw() {
        System.out.println("Shape");
//        System.out.println(name);
    }
}

class Line extends Shape {
//    @Override : 꼭 써야하는 것은 아님
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}
class Circle extends Shape {
    protected String name;

    public void draw() {
        name = "Circle";
        super.name = "Shape";
        super.draw(); // 위부터 탐색
        System.out.println(name);
        System.out.println("Circle");
    }
}

public class Ex33 {
    static void paint(Shape p) { // 상위 타입 참조 변수
        p.draw();
        /*
        동적 바인딩 1:n 매핑 관계
        -> p가 가리키는 객체 내에 오버라이딩된 draw() 호출
        컴파일 시에는 Shape의 draw를 가리키며, 런타임에는 해당 객체의 draw를 가리킴
         */
    }
    public static void main(String[] args) {
        Line line = new Line();
        paint(line);
        paint(new Shape());
        paint(new Line());
        paint(new Rect());
        paint(new Circle());

        System.out.println("======================");
        // 링크드 리스트처럼 활용 가능
        Shape start, last, obj;
        start = new Line();
        last = start;
        obj = new Rect();
        last.next = obj;
        last = obj;
        obj = new Line();
        last.next = obj;
        last = obj;
        obj = new Circle();
        Shape p = start;
        while (p!=null) {
            p.draw();
            p = p.next;
        }

        System.out.println("======================");
        Shape b = new Circle();
        b.paint();
    }
}
/*
Line
Shape
Line
Rect
Circle
 */