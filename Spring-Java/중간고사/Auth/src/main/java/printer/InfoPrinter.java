package printer;

import entity.User;

/*
세부 정보를 프린트 하는 객체
 */
public class InfoPrinter {
    public void print(User user) {
        System.out.print("아이디 : " + user.getId() + " ");
        System.out.print("이메일 : " + user.getEmail() + " ");
        System.out.print("이름 : " + user.getName() + " ");
        System.out.print("전화번호 : " + user.getPhone() + " ");
        System.out.println();
    }
}
