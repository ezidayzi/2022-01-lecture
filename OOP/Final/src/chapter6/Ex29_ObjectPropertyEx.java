package chapter6;

import java.util.Objects;

class Point_29 {
    private int x, y;
    public Point_29(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // toString 오버라이딩
    public String toString() {
        return "Point_29{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    // equals 함수 오버라이딩
    public boolean equals(Object obj) {
        Point_29 p = (Point_29) obj;
        return x == p.x && y == p.y;
    }

}

public class Ex29_ObjectPropertyEx {
    public static void print(Object obj) {
        System.out.println(obj.getClass().getName()); // 클래스 이름 출력
        System.out.println(obj.hashCode()); // 해시코드 값
        System.out.println(obj.toString()); // 객체를 문자열로 만들어 출력
        System.out.println(obj); // 객체 출력
        System.out.println(obj+"입니다"); // toString 문자열로 자동 변환
    }
    public static void main(String[] args) {
        Point_29 p = new Point_29(2, 3);
        print(p);
        System.out.println("=============");
        /*
        == 비교
         */
        Point_29 a = new Point_29(2, 3);
        Point_29 b = new Point_29(2, 3);
        Point_29 c = a;

        System.out.println(a==b); // false - 다른 객체 이므로 당연히 false
        System.out.println(a==c); // true -  같은 객체이므로 true

        System.out.println("=============");

        /*
        equals 오버라이딩 후 비교
         */
        System.out.println(a==b); // false - 다른 객체 이므로 레퍼런스 비교를 하게 됨면 false
        System.out.println(a==c); // true -  같은 객체이므로 true

        // equals를 오버라이딩 해두었으므로 객체의 내용이 같으면 같다고 판단함
        System.out.println(a.equals(b)); // true - 객체의 내용이 같으므로
        System.out.println(a.equals(c)); // true - 객체의 내용이 같으므로
        System.out.println(b.equals(c)); // true - 객체의 내용이 같으므로
    }
}
/* toString 오버라이딩 안헀을 경우
chapter6.Point_29
918221580
chapter6.Point_29@36baf30c -> 해시코드 값이 16진수로 표현되어 봉미
chapter6.Point_29@36baf30c
 */

/* toString 오버라이딩 했을 경우
chapter6.Point_29
918221580
Point_29{x=2, y=3}
Point_29{x=2, y=3}
Point_29{x=2, y=3}입니다
 */