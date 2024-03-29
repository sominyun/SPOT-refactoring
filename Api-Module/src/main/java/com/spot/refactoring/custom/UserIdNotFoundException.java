package com.spot.refactoring.custom;

import com.spot.refactoring.global.BusinessException;
import com.spot.refactoring.global.code.ErrorCode;

public class UserIdNotFoundException extends BusinessException {

    public UserIdNotFoundException(String optionalMessage) {
        super(ErrorCode.NOT_FOUND_USER, optionalMessage);
    }
}
