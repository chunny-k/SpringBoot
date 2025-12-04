package com.example.chunsam.domain.auth.exception;

import com.example.chunsam.global.apiPayload.code.BaseErrorCode;
import com.example.chunsam.global.apiPayload.exception.GeneralException;

public class AuthException extends GeneralException {
    public AuthException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
