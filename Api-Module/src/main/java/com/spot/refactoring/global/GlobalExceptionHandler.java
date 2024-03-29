package com.spot.refactoring.global;

import com.spot.refactoring.global.code.GlobalErrorCode;
import com.spot.refactoring.global.dto.ErrorResponse;
import com.spot.refactoring.global.dto.FieldError;
import com.spot.refactoring.global.dto.ValidationErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(BusinessException ex) {
        log.error("[Custom_Exception]: {}", convertExceptionStackTraceToString(ex));

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(new ErrorResponse(ex.getCode(), ex.getMessage()));
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ) {
        log.error("[MethodArgument_NotValid_Exception]: {}", convertExceptionStackTraceToString(ex));

        List<FieldError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new FieldError(
                        error.getField(),
                        error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                        error.getDefaultMessage()
                )).toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ValidationErrorResponse(
                        GlobalErrorCode.METHOD_ARGUMENT_NOT_VALID.getCode(),
                        GlobalErrorCode.METHOD_ARGUMENT_NOT_VALID.getMessage(),
                        errors
                ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("[Constraint_Violation_Exception]: {}", convertExceptionStackTraceToString(ex));

        List<FieldError> errors = ex.getConstraintViolations().stream()
                .map(violation -> new FieldError(
                        getFieldName(violation),
                        violation.getInvalidValue().toString(),
                        violation.getMessage()
                )).toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ValidationErrorResponse(
                        GlobalErrorCode.CONSTRAINT_VIOLATION.getCode(),
                        GlobalErrorCode.CONSTRAINT_VIOLATION.getMessage(),
                        errors
                ));
    }

    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request
    ) {
        log.error("[Spring_MVC_Standard_Exception]: {}", convertExceptionStackTraceToString(ex));

        GlobalErrorCode globalErrorCode = GlobalErrorCode.from(ex.getClass());

        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(
                        globalErrorCode.getCode(),
                        globalErrorCode.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error("[Exception]: {}", convertExceptionStackTraceToString(ex));

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        GlobalErrorCode.UNHANDLED.getCode(),
                        GlobalErrorCode.UNHANDLED.getMessage()
                ));
    }

    private static String getFieldName(ConstraintViolation<?> violation) {
        String propertyPath = violation.getPropertyPath().toString();
        int dotIdx = propertyPath.lastIndexOf(".");
        return propertyPath.substring(dotIdx + 1);
    }

    private static String convertExceptionStackTraceToString(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        return String.valueOf(stringWriter);
    }
}
