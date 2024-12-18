package pbc.schedule.exception;


/**
 * 비밀번호 불일치 예외
 */
public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
