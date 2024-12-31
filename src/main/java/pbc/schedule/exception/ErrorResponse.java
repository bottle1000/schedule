package pbc.schedule.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 예외 응답 객체
 */
@AllArgsConstructor
@Getter
public class ErrorResponse {
    private String message;
    private int status;
}
