package exception;

public class InvalidEmailException  extends RuntimeException {
    public InvalidEmailException() {
        super("올바른 이메일 형식이 아닙니다.");
    }
}
