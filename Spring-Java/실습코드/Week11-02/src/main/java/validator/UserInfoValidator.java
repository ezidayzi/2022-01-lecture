package validator;

import model.UserInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import repository.UserRepository;
import service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoValidator implements Validator {
    private UserService userService;
    // 이메일 형식 정규 표현식 문자열
    private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-zZa-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    public UserInfoValidator() {
        pattern = Pattern.compile(emailRegExp);
        userService = new UserService(new UserRepository());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserInfo.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserInfo userInfo = (UserInfo)target;
        // 이메일 형식 검사
        if(userInfo.getEmail() == null || userInfo.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        }
        else {
            Matcher matcher = pattern.matcher(userInfo.getEmail()); if(!matcher.matches()) {
                errors.rejectValue("email", "bad"); }
        }

        // 중복 검사
        if (userService.searchWithEmail(userInfo.getEmail()) !=  null) {
            errors.rejectValue("email", "duplicated");
        }

        if (userService.searchWithId(userInfo.getId()) !=  null) {
            errors.rejectValue("id", "duplicated");
        }

        if (userService.searchWithPhone(userInfo.getPhone()) !=  null) {
            errors.rejectValue("phone", "duplicated");
        }

    }
}
