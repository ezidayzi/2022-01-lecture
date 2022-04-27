package exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
        super("이미 가입된 아이디가 존재합니다.");
    }
}
