import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("소문자 알파벳 하나를 입력하시오>>");
        char c = scan.nextLine().charAt(0);

        while ( c >= 'a' && c <= 'z') {
            char a = c;
            while (a >= 'a') {
                System.out.print(a);
                a--;
            }
            System.out.println();
            c--;
        }

        scan.close();
    }
}
