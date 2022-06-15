package Exam_etc;

class Person {
    String name;
    String id;

    public Person(String name) {
        this.name = name;
    }
}
class Student extends Person {
    String grade;
    String department;
    public Student(String name) {
        super(name);
    }
}
public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s, t;
        s = new Student("얼굴값을");
        p = s;
        System.out.println(p.name);
        p.id = "못한대";
        System.out.println(p.id);
        t = s;
//        t = new Student("너도 얼굴값을");
        t.grade = "전혀";
        System.out.println(t.grade);
    }
}