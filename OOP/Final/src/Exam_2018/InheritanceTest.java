package Exam_2018;
class FirstChild extends Parent{
    public String read(){
        return super.read() + "1";
    }
}

class SecondChild extends Parent{
    public String read(){
        return super.read() + "2";
    }

    public void sc() {
        System.out.println("tc");
    }
}

class ThirdChild extends Parent{
    Parent p;

    public ThirdChild(Parent p){
        this.p = p;
    }


    public String read(){
        return p.read() + "3";
    }
}

public class InheritanceTest{
    public static void main(String[] args){
        FirstChild fc = new FirstChild();
        System.out.println(fc.read());

        SecondChild sc = new SecondChild();
        System.out.println(sc.read());

        ThirdChild tc1 = new ThirdChild(fc);
        System.out.println(tc1.read());

        ThirdChild tc2 = new ThirdChild(sc);
        System.out.println(tc2.read());

        Parent pp = new SecondChild();
        ((SecondChild)pp).sc();
    }
}

class Parent{
    public String read(){
        return "P";
    }
}
/*
P1
P2
P13
P23
 */