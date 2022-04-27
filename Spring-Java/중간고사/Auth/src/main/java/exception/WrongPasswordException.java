package exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("암호가 일치하지 않습니다.");
    }
}
