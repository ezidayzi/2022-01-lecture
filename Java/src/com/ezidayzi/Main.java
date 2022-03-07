package com.ezidayzi;

public class Main {

    public static void main(String[] args) {

        //- 출력문(System.out.println 또는 System.out.printf 모두 가능)
        System.out.println("Hello, world! Welcome to Java Programming");
        System.out.printf("Hello, %s", "김윤서");

        // - 상수(단순 숫자/문자 표현 및 final 키워드 모두 사용)
        final int todayMonth = 3;
        final float date = 7.0F;
        final String day = "월요일";

        //- 변수
        /// bool
        boolean isSuccess = true;

        /// char
        char a1 = 'a';
        char b2 = 98;

        /// String
        String message = "자바프로그래밍 강의에 오신걸 환영해요!";
        System.out.println("Message: " + message);
        System.out.printf("Message: %s", message);
        System.out.println(message.charAt(6));
        System.out.println(message.replaceAll("자바프로그래밍", "자바"));

        /// Int
        int number = 1234567;
        System.out.println("Number: " + number);
        System.out.printf("Number: %d", number);

        /// Sting -> Int 형변환
        String num = "2000";
        int n = Integer.parseInt(num); // 형변환
        System.out.println(n);  // 200 출력

        /// Int -> String 형변
        int age = 23;
        String age1 = String.valueOf(age);
        String age2 = Integer.toString(age);
        System.out.println(age1);  // 23 출력
        System.out.println(age2);  // 23 출력

        //- 반복문(for문, while문 모두 사용)
        for(int i = 1; i < 10; i+=1) {
            for(int j= 1; j < 10; j+=1) {
                if(i%2 == 0) continue;
                System.out.printf("%d * %d = %d\n", i, j, i*j);
            }
        }

        /// for
        String[] launch = {"떡볶이", "김밥", "쫄면"};
        for(int i=0; i<launch.length; i++) {
            System.out.println(launch[i]+"먹고싶어요!");
        }

        /// while
        int bread = 0;
        while (bread < 10) {
            bread++;
            System.out.println("빵을  " + bread + "개 샀습니다");
            if (bread == 10) {
                System.out.println("빵 10개를 구매하셨군요! 서비스빵 한개 더~");
            }
        }

        //- 조건문(if문, switch문 모두 사용)
        /// switch
        int month = 3;
        String monthString = "";
        switch (month) {
            case 1:  monthString = "1월";
                break;
            case 2:  monthString = "2월";
                break;
            case 3:  monthString = "3월";
                break;
            case 4:  monthString = "4월";
                break;
            case 5:  monthString = "5월";
                break;
            case 6:  monthString = "6월";
                break;
            case 7:  monthString = "7월";
                break;
            case 8:  monthString = "8월";
                break;
            case 9:  monthString = "9월";
                break;
            case 10: monthString = "10월";
                break;
            case 11: monthString = "11월r";
                break;
            case 12: monthString = "12월";
                break;
            default: monthString = "유효하지 않군요";
                break;
        }
        System.out.println(monthString+ "입니다");

        /// if
        boolean hungry = true;
        if (hungry) {
            System.out.println("밥드세요!");
        }else {
            System.out.println("디저트를 드세요!");
        }

        //- 예외처리(try … catch 문은 반드시 사용, 이외의 확장내용은 자유)
        for(int k = 0; k < 10 ; k++) {
            try {
                System.out.printf("%d / %d = %d\n", 100, k, 100 / k);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
        }

        /// try-catch
        try{ Exception err = new Exception("고의발생");
            throw err;
        } catch (Exception e) {
            System.out.println("에러메세지:" + e.getMessage()); e.printStackTrace();
        } System.out.println("프로그램 정상 종료.");
    }
}