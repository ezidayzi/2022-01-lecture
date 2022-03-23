import carFactory.*;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Human human;
//        Korean korean = new Korean();
//        British british = new British();
//        American american = new American();
//
//        human = korean;
//        human.wakeUp();
//        human.introduce();
//        human.eat();
//        human.walk();
//        human.sleep();
//
//        human = british;
//        human.wakeUp();
//        human.introduce();
//        human.eat();
//        human.walk();
//        human.sleep();
//
//        human = american;
//        human.wakeUp();
//        human.introduce();
//        human.eat();
//        human.walk();
//        human.sleep();

        // FileInputStream, Scanner 클래스 사용 시 예외가 발생하므로 예외처리 루틴 추가
        try {
            FileInputStream in = new FileInputStream("src/class_setting.txt");
            Scanner aScan = new Scanner(in);
            String className = aScan.nextLine();
            System.out.println(className); // 설정파일에서 기록한 클래스 이름 확인
            aScan.close();
            in.close();
            Class<?> aClass = Class.forName(className);
            Human human1 = (Human) aClass.getDeclaredConstructor().newInstance();
            human1.wakeUp();
            human1.introduce();
            human1.eat();
            human1.walk();
            human1.sleep();
        } catch(Exception e) {
            e.printStackTrace(); // 예외 발생 시 그 내용 확인
        }


        몸통 튼튼몸통 = new 몸통();
        튜브 질긴튜브 = new 튜브();
        휠 씽씽휠 = new 휠();

        타이어 신발보다싼타이어 = new 타이어(질긴튜브);
        바퀴 좋은바퀴 = new 바퀴(신발보다싼타이어, 씽씽휠);
        자동차 람보르기니 = new 자동차(좋은바퀴, 튼튼몸통);
    }
}
