package com.spot.refactoring.global.dto;

import java.util.List;

public record ValidationErrorResponse(
        Integer code,
        String message,
        List<FieldError> errors
) {
}
