package com.spot.refactoring.custom;

import com.spot.refactoring.global.BusinessException;
import com.spot.refactoring.global.code.ErrorCode;

public class UserIdAlreadyExistsException extends BusinessException {
    public UserIdAlreadyExistsException() {
        super(ErrorCode.USER_ID_ALREADY_EXISTS);
    }
}
