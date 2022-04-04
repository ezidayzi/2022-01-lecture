import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오>>");

        int input = scan.nextInt();
        int count = 0;

        if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9) {
            count++;
        }

        if (input / 10 == 3 || input / 10 == 6 || input / 10 == 9) {
            count++;
        }

        if (count == 1) {
            System.out.println("박수짝");
        } else if (count == 2) {
            System.out.println("박수짝짝");
        }

        scan.close();
    }
}
