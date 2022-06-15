package Exam_etc;

class D2{
    int a;
    public D2(){
        System.out.println("정");
        this.a=55555;
    }
    public D2(int a){
        this.a=a;
        System.out.println("너");
    }
}

class E2 extends D2{

    public E2(){ super(18);
        System.out.println("잘생겼다");
    }
    public E2(double f){
        System.out.println("말");
    }
}
class F2 extends E2{
    public F2(){
        System.out.println("는구라");
    }
}
public class ConstructorTest {
    public static void main(String[] args) {
        E2 e=new E2();
        System.out.println(e.a);
        E2 t=new E2(5.5);
        System.out.println(t.a);
        F2 k=new F2();
    }
}

/*
너
잘생겼다
18
정
말
55555
너
잘생겼다
 */