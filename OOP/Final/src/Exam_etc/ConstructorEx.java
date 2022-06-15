package Exam_etc;

class A3{
    int a;
    public A3(){
        System.out.println("백웅기");
    }
    public A3(int a){
        System.out.println("이성엽");
        this.a=a;
    }
    void midtermexam(){
        System.out.println("김유진");
    }
}
class B3 extends A3{
//    int a;
    public B3(int a){
        System.out.println("차윤성");
        super.a=a;
    }
    public B3(){
        System.out.println("♥김동우♥");
    }
    void midtermexam(){
        super.midtermexam();
        System.out.println("김도형");
    }
}
public class ConstructorEx {
    public static void main(String[] arg) {
        B3 a = new B3(5);
        System.out.println(a.a);
        a.a = 7;
        System.out.println(a.a);
        a.midtermexam();
        A3 t = new B3();
        t.midtermexam();
        A3 b = new A3();
        b.midtermexam();
    }
}
/*
백웅기
차윤성
5
7
김유진
김도형
백웅기
♥김동우♥
김유진
김도형
백웅기
김유진
 */