package com.ezidayzi;

// 1. 객체지향 프로그램의 시작
// (1) 클래스를 만들고 해당 클래스의 인스턴스를 만들어보세요.
public class Student {
    private String name;
    private Integer age;
    private Integer studentId;
    private Boolean graduation;

    public String makeIntroduction() {
        return "안녕하세요 저는 " + name + " 입니다.";
    }

    //Getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return  studentId;
    }

    public void isGraduate() {
        if (graduation) {
            System.out.println("졸업생입니다.");
        } else {
            System.out.println("재학생입니다.");
        }
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setGraduation(boolean graduation) {
        this.graduation = graduation;
    }
}

