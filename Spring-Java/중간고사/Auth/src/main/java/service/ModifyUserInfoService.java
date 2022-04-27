package service;

import dto.ModifyRequest;
import entity.User;
import exception.NoUserException;
import exception.WrongInfoException;
import mather.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

@Component
public class ModifyUserInfoService {
    private UserRepository userRepository;

    private PatternMatcher matcher;

    @Autowired
    public void setMatcher(PatternMatcher matcher) {
        this.matcher = matcher;
    }

    @Autowired
    public void setUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void isValidUser(String id, String email, String phone) {
        User user = userRepository.read(id);

        if (user == null) {
            throw new NoUserException();
        }

        if (!(user.getId().equals(id) && user.getEmail().equals(email) && user.getPhone().equals(phone))) {
            throw new WrongInfoException();
        }
    }

    public void modifyInfo(String id, ModifyRequest req){
        User user = userRepository.read(id);

        if (user == null) {
            throw new NoUserException();
        }

        if (req.getPhone() != null)
            user.setPhone(req.getPhone());

        if (req.getName() != null)
            user.setName(req.getName());

        if (req.getEmail() != null)
            user.setEmail(req.getEmail());

        userRepository.update(user);
    }

    public void isValidEmail(String email) {
        matcher.isValidEmail(email);
    }

    public void isValidPhoneNumber(String phone) {
        matcher.isValidPhoneNumber(phone);
    }

}
