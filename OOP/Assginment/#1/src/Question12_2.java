import java.util.Scanner;

public class Question12_2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("연산>>");

        double num1 = scan.nextDouble();
        String operator = scan.next();
        double num2 = scan.nextDouble();


        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    scan.close();
                    return;
                }
                result = num1 / num2;
                break;

            default:
                break;
        }

        System.out.println(num1+operator+num2+"의 계산 결과는 "+result);

        scan.close();
    }
}
