package exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super("아이디는 2글자에서 10글자 사이, 숫자와 영어만 사용 가능합니다.");
    }
}
