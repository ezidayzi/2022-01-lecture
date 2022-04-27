package printer;

import exception.NoUserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import entity.User;
import repository.UserRepository;

import java.util.Collection;

/*
모든 User 들의 정보를 프린트하는 객체
 */
@Component
public class UserListPrinter {
    private UserRepository userRepository;

    private InfoPrinter printer;

    @Autowired
    public void setUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    @Qualifier("normal") // InfoPrinter 주입
    public void setPrinter(InfoPrinter printer) {
        this.printer = printer;
    }

    public void print() {
        Collection<User> users = userRepository.selectAll();
        if (users.isEmpty())
            throw new NoUserInfoException();
        System.out.println("-----------------------[ 회원 리스트 조회 ]-----------------------");
        users.forEach(u -> printer.print(u));
    }

}
