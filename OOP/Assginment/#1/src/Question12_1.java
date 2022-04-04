import java.util.Scanner;

public class Question12_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("연산>>");

        double num1 = scan.nextDouble();
        String operator = scan.next();
        double num2 = scan.nextDouble();

        double result = 0;
        if (operator.equals("+")) {
            result = num1+num2;
        } else if (operator.equals("-")) {
            result = num1-num2;
        } else if (operator.equals("*")) {
            result = num1*num2;
        } else if (operator.equals("/")) {
            if (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                scan.close();
                return;
            }
            result = num1/num2;
        }

        System.out.println(num1+operator+num2+"의 계산 결과는"+result);
        scan.close();
    }
}
