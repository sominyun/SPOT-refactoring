package com.spot.refactoring.custom;


import com.spot.refactoring.global.BusinessException;
import com.spot.refactoring.global.code.ErrorCode;

public class NicknameDuplicateException extends BusinessException {
    public NicknameDuplicateException() {
        super(ErrorCode.NICKNAME_DUPLICATE);
    }
}
