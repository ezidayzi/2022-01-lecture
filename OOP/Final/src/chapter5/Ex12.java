package chapter5;
/*
부모클래스
 */
class Person {
    private int weight;
    int age;
    protected int height;
    public String name;
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
}
/*
자식클래스
 */
class Student extends Person {
    public void set() {
        age = 30;
        name = "홍길동";
        height = 175;
//        weight = 99; // 컴파일에러, private 접근 불가
        setWeight(99); // weight는 getter와 setter로 접근 가능함
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Student s = new Student();
        s.set();
        s.getWeight();  // s의 부모인 person의 메소드 접근 가능
    }
}
