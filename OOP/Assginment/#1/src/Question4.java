import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수 3개 입력>>");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        int middle;
        if((num1 > num2 && num1 < num3) || (num1 > num3 && num1 < num2)) {
            middle = num1;
        } else if((num2 > num1 && num2 < num3) || (num2 > num3 && num2 < num1)){
            middle = num2;
        } else {
            middle = num3;
        }

        System.out.println("중간 값은 " + middle);

        scan.close();
    }
}
