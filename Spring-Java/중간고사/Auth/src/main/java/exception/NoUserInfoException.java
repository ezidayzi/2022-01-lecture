package exception;

public class NoUserInfoException extends RuntimeException {
    public NoUserInfoException() {
        super("회원이 존재하지 않습니다.");
    }
}
