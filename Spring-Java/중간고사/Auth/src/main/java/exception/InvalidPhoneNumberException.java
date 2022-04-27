package exception;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException() {
        super("올바른 휴대전화 형식이 아닙니다. ");
    }
}
