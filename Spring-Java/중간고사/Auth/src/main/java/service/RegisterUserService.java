package service;
import dto.RegisterRequest;
import entity.User;
import exception.*;

import mather.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.UserRepository;

@Component
public class RegisterUserService {
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

    /*
    새로운 유저 등록
     */
    public String register(RegisterRequest req) {
        User newUser = new User();
        newUser.setId(req.getId());
        newUser.setPassword(req.getPassword());
        newUser.setEmail(req.getEmail());
        newUser.setPhone(req.getPhone());
        newUser.setName(req.getName());

        userRepository.insert(newUser);
        return newUser.getId();
    }

    public void isValidId(String id) { // 아이디 검사
        if (userRepository.read(id) != null) { // 이미 가입된 아이디인 경우
            throw new DuplicateUserException();
        }

        matcher.isValidId(id);
    }

    public void isValidEmail(String email) { // 이메일 형식 검사
        matcher.isValidEmail(email);
    }

    public void isValidPassword(String password) { // 패스워드 검사
        matcher.isValidPassword(password);
    }

    public void isPasswordEqualToConfirmPassword(String password, String confirmPassword) { // 확인 암호 일치 검사
        matcher.isPasswordEqualToConfirmPassword(password, confirmPassword);
    }

    public void isValidPhoneNumber(String phone) { // 전화번호 형식 검사
        matcher.isValidPhoneNumber(phone);
    }

}
