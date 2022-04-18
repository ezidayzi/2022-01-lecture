import java.util.Scanner;

public class Q16 {
    public static void main(String[] args) {
        String[] str = {"가위", "바위", "보"};
        Scanner scan = new Scanner(System.in);

        System.out.println("컴퓨터와 가위바위보 게임을 합니다.");

        while (true) {
            System.out.print("가위 바위 보!>>");
            int n = (int) (Math.random() * 3);

            String user = scan.nextLine();

            boolean status = false;
            for (String s : str) {
                status = s.equals(user);
                if (status) break;
            }

            if(user.equals("그만") || !status) {
                // 가위 바위 보 이외의 문자를 입력했을 경우와 그만을 입력했을 경우 프로그램 종료
                System.out.println("게임을 종료합니다.");
                break;
            }

            System.out.print("사용자 = " + user + " , 컴퓨터 = " + str[n] + ", ");

            if (user.equals(str[n])) { // 비기는 경우
                System.out.println("비겼습니다.");
            }
            else { // 사용자와 컴퓨터가 다른 것을 내는 경우
                boolean win = false;
                // false - 컴퓨터가 이김, true- 사용자가 이김
                // 사용자가 지는 경우는 컴퓨터가 이기는 경우이므로 사용자가 이기는 경우만 체크
                switch (str[n]) {
                    case "가위":
                        if (user.equals("바위")) {
                            win = true;
                        }
                        break;
                    case "바위":
                        if (user.equals("보")) {
                            win = true;
                        }
                        break;
                    case "보":
                        if (user.equals("가위")) {
                            win = true;
                        }
                        break;
                }

                if (win) {
                    System.out.println("사용자가 이겼습니다.");
                } else {
                    System.out.println("컴퓨터가 이겼습니다.");
                }
            }
        }

        scan.close();

    }
}
