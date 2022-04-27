package exception;

public class ExitServiceException extends RuntimeException{
    public ExitServiceException(String svc) {
        super(svc + "을/를 종료합니다.\n");
    }
}
