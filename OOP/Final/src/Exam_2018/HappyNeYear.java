package Exam_2018;
class SS {
    static int i;
    int t;
    final int a;
    static {
        i = 0;
        System.out.println("SS: Static 변수 초기화");
    }

    {
        t = 0;
        a = 1;
        System.out.println("SS: 필드 초기화");
    }

    SS() {
        this.t = 0;
        System.out.println("SS: SS의 생성자");
    }

    static void ss() {
        System.out.println("SS: Static 메서드");
    }
}
class S extends SS{
    static int i;
    int t;
    final int a;
    static {
        i = 0;
        System.out.println("Static 변수 초기화");
    }

    {
        t = 0;
        a = 1;
        System.out.println("필드 초기화");
    }
    S() {
        System.out.println("S의 생성자");
    }

    static void ss() {
        System.out.println("Static 메서드");
    }
}
//        new S();
public class HappyNeYear {
    public static void main(String[] args) {
        String str1 = "Happy ";
        String str2 = str1;
        str2 += "New Year ";
        str1 = str2.substring(6);
        System.out.println(str1 + str2);
    }
}
/*
New Year Happy New Year
 */