package com.spot.refactoring.global.dto;

public record ErrorResponse(
        Integer code,
        String message
) {
}
