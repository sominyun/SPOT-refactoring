package com.spot.refactoring.custom;

import com.spot.refactoring.global.BusinessException;
import com.spot.refactoring.global.code.ErrorCode;

public class NicknameValidationException extends BusinessException {
    public NicknameValidationException() {
        super(ErrorCode.NICKNAME_VALIDATION);
    }

}
