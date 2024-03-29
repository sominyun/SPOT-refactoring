package com.spot.refactoring.global;

import com.spot.refactoring.global.code.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;

    public BusinessException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public BusinessException(ErrorCode errorCode, String optionalMessage) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage() + " " + optionalMessage;
        this.httpStatus = errorCode.getHttpStatus();
    }
}
