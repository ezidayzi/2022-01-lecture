package service;

import entity.User;
import exception.NoUserException;
import exception.WrongInfoException;

import mather.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;


@Component
public class ResetPasswordService {
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

    public void resetPassword(String id, String email, String phone){
        User user = userRepository.read(id);

        if (user == null) {
            throw new NoUserException();
        }

        if (!(user.getId().equals(id) && user.getEmail().equals(email) && user.getPhone().equals(phone))) {
            throw new WrongInfoException();
        }

        user.setPassword(null);
        userRepository.update(user);
    }

    public void registerNewPassword(String id, String newPassword, String confirmPassword) {
        matcher.isValidPassword(newPassword);
        matcher.isPasswordEqualToConfirmPassword(newPassword, confirmPassword);

        User user = userRepository.read(id);
        user.setPassword(newPassword);
        userRepository.update(user);
    }

}
