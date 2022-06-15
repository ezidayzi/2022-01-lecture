package chapter6;

public class Ex43_String {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Java";
        String c = "Hello";
        String d = new String("Hello");
        String e = new String("Java");
        String f = new String("Hello");

        /*
        리터럴은 자바가상기계의 스트링 리터럴 테이블을 이용한다.
         */
        System.out.println(a==c); // true

        /*
        new를 이용하면 String 객체가 생성된다.
        -> equals를 이용한 비교를 할것
         */
        System.out.println(a==d); // false
        System.out.println(d==f); // false
        System.out.println(d.equals(f)); // true

        /*
        intern: 스트링 리터럴 테이블에 등록하는 행위
         */
        String g = d.intern();
        System.out.println(a==g); // true
        System.out.println(c==g); //true
        System.out.println(d==g); //false


    }
}
