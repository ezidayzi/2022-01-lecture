package service;

import entity.User;
import exception.NoUserException;
import exception.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

@Component
public class UserLoginService {
    private UserRepository userRepository;

    @Autowired
    public void setUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String id, String password) {
        User user = userRepository.read(id);

        if (user == null) {
            throw new NoUserException();
        }

        if ( !password.equals(user.getPassword())) {
            throw new WrongPasswordException();
        }

        return user;
    }

}
