package com.spot.refactoring.global.code;

import jakarta.validation.ConstraintViolationException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

// 스프링 MVC 예외 목록
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GlobalErrorCode {

    UNHANDLED(1000, "알 수 없는 서버 에러가 발생했습니다.", null),

    /**
     * Validation Exception
     */
    METHOD_ARGUMENT_NOT_VALID(1100, "데이터 유효성 검사에 실패했습니다.", MethodArgumentNotValidException.class),
    CONSTRAINT_VIOLATION(1101, "데이터 유효성 검사에 실패했습니다.", ConstraintViolationException.class),

    /**
     * Standard Spring MVC Exception
     */
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(1200, "지원하지 않는 HTTP 요청 메서드입니다.", HttpRequestMethodNotSupportedException.class),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED(1201, "지원하지 않는 미디어 타입입니다.", HttpMediaTypeNotSupportedException.class),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE(1202, "요청한 미디어 타입으로 응답을 생성할 수 없습니다.", HttpMediaTypeNotAcceptableException.class),
    MISSING_PATH_VARIABLE(1203, "필요한 path variable 변수가 누락되었습니다.", MissingPathVariableException.class),
    MISSING_SERVLET_REQUEST_PARAMETER(1204, "필요한 요청 parameter가 누락되었습니다.", MissingServletRequestParameterException.class),
    SERVLET_REQUEST_BINDING(1205, "servlet 요청 바인딩에 문제가 발생했습니다.", ServletRequestBindingException.class),
    CONVERSION_NOT_SUPPORTED(1206, "빈의 프로퍼티나 메서드에 해당 값으로의 변환을 수행할 수 없습니다.", ConversionNotSupportedException.class),
    TYPE_MISMATCH(1207, "입력받은 데이터가 메서드 인자나 필드의 타입과 일치하지 않습니다.", TypeMismatchException.class),
    HTTP_MESSAGE_NOT_READABLE(1208, "HTTP 메시지 컨버터가 요청 본문을 읽을 수 없습니다.", HttpMessageNotReadableException.class),
    HTTP_MESSAGE_NOT_WRITABLE(1209, "HTTP 메시지 컨버터가 응답 본문을 쓸 수 없습니다.", HttpMessageNotWritableException.class),
    MISSING_SERVLET_REQUEST_PART(1210, "mutipart 요청에서 필요한 부분이 누락되었습니다.", MissingServletRequestPartException.class),
    BIND(1211, "데이터 바인딩 중 문제가 발생했습니다.", BindException.class),
    NO_HANDLER_FOUND(1212, "적절한 핸들러를 찾을 수 없습니다.", NoHandlerFoundException.class),
    ASYNC_REQUEST_TIMEOUT(1213, "비동기 요청 처리 시간이 초과되었습니다.", AsyncRequestTimeoutException.class),
    ;

    private final Integer code;
    private final String message;
    private final Class<? extends Exception> classType;

    public static GlobalErrorCode from(Class<? extends Exception> classType) {
        return Arrays.stream(values())
            .filter(ex -> ex.getClassType() != null && ex.getClassType().equals(classType))
            .findFirst()
            .orElse(UNHANDLED);
    }
}
