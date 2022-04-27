package exception;

public class NoUserException extends RuntimeException {
    public NoUserException() {
        super("가입된 아이디가 존재하지 않습니다.");
    }
}
