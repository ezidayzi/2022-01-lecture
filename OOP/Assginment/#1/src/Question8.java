import java.util.Scanner;

public class Question8 {
    public static boolean outRect(int x, int y) {
        return (x < 100 || x > 200) || (y < 100 || y > 200);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("점 (x1, y1)의 좌표를 입력하시오>>");

        int x1 = scan.nextInt();
        int y1 = scan.nextInt();

        System.out.print("점 (x2, y12)의 좌표를 입력하시오>>");

        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        if (outRect(x1, y1) && outRect(x1, y2) && outRect(x2, y1) && outRect(x2, y2)) {
            System.out.println("충돌하지 않습니다.");
        } else {
            System.out.println("충돌합니다.");
        }

        scan.close();
    }
}
