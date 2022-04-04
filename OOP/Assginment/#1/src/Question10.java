import java.util.Scanner;

public class Question10 {
    static double getDistance(double x, double y, double x1, double y1) {
        double d;
        int xd, yd;
        yd = (int) Math.pow((y1-y),2);
        xd = (int) Math.pow((x1-x),2);
        d = Math.sqrt(yd+xd);
        return d;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("첫번째의 원의 중심과 반지름 입력>>");
        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        double r1 = scan.nextDouble();

        System.out.print("두번째 원의 중심과 반지름 입력>>");
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();
        double r2 = scan.nextDouble();

        double d = getDistance(x1, y1, x2, y2);

        if (d < r1 + r2) {
            System.out.println("두 원은 서로 겹친다.");
        } else {
            System.out.println("두 원은 서로 겹치지 않는다.");
        }

        scan.close();
    }
}
