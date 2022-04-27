package printer;

import exception.NoUserInfoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import entity.User;
import repository.UserRepository;

/*
특정 User 의 정보를 프린트하는 객체
 */
@Component
public class UserInfoPrinter {
    private UserRepository userRepository;

    private InfoPrinter printer;

    @Autowired
    public void setUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    @Qualifier("detail") // DetailInfoPrinter 주입
    public void setPrinter(InfoPrinter printer) {
        this.printer = printer;
    }

    public void print(String id) {
        User user = userRepository.read(id);

        if (user == null) {
            throw new NoUserInfoException();
        }
        printer.print(user);
    }

}
