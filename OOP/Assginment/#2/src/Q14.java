import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        String[] course = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
        int[] score = {95, 88, 76, 62, 55};

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("과목 이름>>");
            String input = scan.next();
            if ("그만".equals(input) ) {
                break;
            }

            String message = "없는 과목입니다";
            int flag = -1;
            for (int i = 0; i< course.length; i++) {
                if (course[i].equals(input)){
                    message = course[i] + "의 점수는 " + score[i];
                }
            }

            System.out.println(message);
        }

        scan.close();
    }
}
