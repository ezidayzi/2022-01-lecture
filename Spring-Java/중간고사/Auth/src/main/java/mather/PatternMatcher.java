package mather;

import exception.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    /*
    올바른 아이디 형식인지 검증
     */
    public void isValidId(String id) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{2,10}$";
        Matcher m = Pattern.compile(regex).matcher(id);

        if (!m.find()) {
            throw new InvalidIdException();
        }
    }

    /*
    올바를 암호 형식인지 검증
     */
    public void isValidPassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$";
        Matcher m = Pattern.compile(regex).matcher(password);

        if (!m.find()) {
            throw new InvalidPasswordException();
        }
    }

    /*
    동일한 암호인지 확인
     */
    public void isPasswordEqualToConfirmPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    /*
    올바른 이메일 형식인지 확인
     */
    public void isValidEmail(String email) {
        String regex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        if (!Pattern.matches(regex, email)) {
            throw new InvalidEmailException();
        }
    }

    /*
    올바른 전화번호 형식인지 확인
    */
    public void isValidPhoneNumber(String phone) {
        String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";
        if (!Pattern.matches(regex, phone)) {
            throw new InvalidPhoneNumberException();
        }
    }

}
