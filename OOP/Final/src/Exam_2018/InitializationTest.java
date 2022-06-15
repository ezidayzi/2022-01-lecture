package Exam_2018;
class Window{
    Window(int marker){
        System.out.println("Window(" + marker + ")");
    }
}

class House{
    Window w1 = new Window(1);
    House(){
        System.out.println("House( )");
        w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f(){
        System.out.println("f( )");
    }
    {
        w3 = new Window(4);
    }
    Window w3 = new Window(3);
    {
        w3 = new Window(6);
    }
}

public class InitializationTest {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}

/*
Window(1)
Window(2)
Window(3)
House( )
Window(33)
f( )
 */