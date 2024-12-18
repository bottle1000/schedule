package pbc.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<String> handlerInvalidPasswordException(InvalidPasswordException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundAuthorException.class)
    public ResponseEntity<String> handlerNotFoundAuthorException(NotFoundAuthorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundCalenderException.class)
    public ResponseEntity<String> handlerNotFoundCalenderException(NotFoundCalenderException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PageOutOfRangeException.class)
    public ResponseEntity<String> handlerPageOutOfRangeException(PageOutOfRangeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundEmailException.class)
    public ResponseEntity<String> handlerNotFoundEmailException(NotFoundCalenderException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<String> handlerNotFoundUserException(NotFoundUserException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundScheduleIdException.class)
    public ResponseEntity<String> NotFoundScheduleIdException(NotFoundScheduleIdException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
