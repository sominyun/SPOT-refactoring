package com.spot.refactoring.global.dto;

public record FieldError(
        String field,
        String value,
        String reason
) {
}
