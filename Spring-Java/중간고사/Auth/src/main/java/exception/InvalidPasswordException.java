package exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
        super("암호는 영어, 숫자, 특수기호를 포함하여 8자 이상으로 입력해주세요.");
    }
}
