package Exam_2018;

class Parent2 {
    int i = 10;
    public int get() {
        return i;
    }
}

class Child2 extends Parent2 {
    int i = 8;
    public int get(){
        return i;
    }
}

public class ChildTest {
    public static void print(Parent2 p) {
        System.out.println(p.i);
        System.out.println(p.get());
    }

    public static void main(String[] args)  {
        Parent2 p = new Parent2();
        System.out.println(p.i);
        System.out.println(p.get());

        Child2 c = new Child2();
        System.out.println(c.i);
        System.out.println(c.get());

        Parent2 p2 = new Child2();
        System.out.println(p2.i);
        System.out.println(p2.get());

        print(c);
        print(p2);
    }

}

/*
10
10
8
8
10
8
10
8
10
8
 */