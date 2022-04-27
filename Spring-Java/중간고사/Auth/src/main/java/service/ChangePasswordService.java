package service;

import entity.User;
import exception.NoUserException;
import exception.WrongPasswordException;
import mather.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

@Component
public class ChangePasswordService {
    private UserRepository userRepository;

    private PatternMatcher matcher;

    @Autowired
    public void setUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setMatcher(PatternMatcher matcher) {
        this.matcher = matcher;
    }

    public void changePassword(String id, String oldPassword, String newPassword){
        User user = userRepository.read(id);

        if (user == null) {
            throw new NoUserException();
        }

        if (!user.getPassword().equals(oldPassword)) {
            throw new WrongPasswordException();
        }

        matcher.isValidPassword(newPassword);

        user.setPassword(newPassword);
        userRepository.update(user);
    }
}
