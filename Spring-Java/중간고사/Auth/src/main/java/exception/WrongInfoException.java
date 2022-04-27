package exception;

public class WrongInfoException extends RuntimeException{
    public WrongInfoException() {
        super("입력하신 정보가 가입된 정보와 일치하지 않습니다.");
    }
}
