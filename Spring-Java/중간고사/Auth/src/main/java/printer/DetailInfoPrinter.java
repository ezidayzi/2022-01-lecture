package printer;

import entity.User;

/*
InfoPrinter 를 상속받아 세부 정보를 프린트하는 객체
 */
public class DetailInfoPrinter extends InfoPrinter {
    /*
    InfoPrinter 객체의 print 함수를 오버라이드
     */
    @Override
    public void print(User user) {
        System.out.println(user.getId()+"님의 회원정보를 조회합니다.");
        System.out.println("이름 : " + user.getName());
        System.out.println("연락처 : " + user.getPhone());
        System.out.println("이메일 : " + user.getEmail());
    }
}
