import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};

        Scanner scan = new Scanner(System.in);

        System.out.print("금액을 입력하시오>>");
        int m = scan.nextInt();

        for (int u : unit) {
            int cnt = 0;
            while (true) {
                if (m / u == 0) break;
                else {
                    cnt = m / u;
                    m = m % u;
                }
            }
            if (cnt != 0)
                System.out.println(u + "원 짜리 : " + cnt + "개");
        }

        scan.close();
    }
}