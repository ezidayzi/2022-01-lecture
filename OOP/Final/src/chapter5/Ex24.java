package chapter5;

/*
부모 클래스

 */
class Person24 {
    String name;
    String id;

    public Person24(String name) {
        this.name = name;
    }
}
/*
자식클래스
 */
// 슈퍼클래스에 인자가 있는 생성자만 있으면 서브 클래스도 생성자를 통해 슈퍼 클래스의 생성자를 호출해주어야함
class Student24 extends Person24 {
    String grade;
    String department;

    public Student24(String name) {
        super(name);
    }
}

public class Ex24 {
    public static void main(String[] args) {
        Person24 p;
        Student24 s = new Student24("기뮨서");

        p = s; // 업캐스팅

        System.out.println(p.name);

        /*
        p.grade = "A";
        p.department = "CSE";
        컴파일 오류
         */

        Person24 p2 = new Student24("기뮨서"); // 업캐스팅
        Student24 s2;
        /*
        s2 = p;
        컴파일 오류
         */
        s2 = (Student24) p; // 다운 캐스팅

        System.out.println(s2.name);
        s2.grade = "A";
        // 컴파일 오류 없음
    }
}
