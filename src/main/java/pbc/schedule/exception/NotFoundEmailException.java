package pbc.schedule.exception;


/**
 * 없는 이메일에 대한 예외처리
 */
public class NotFoundEmailException extends RuntimeException{

    public NotFoundEmailException(String message) {
        super(message);
    }
}
