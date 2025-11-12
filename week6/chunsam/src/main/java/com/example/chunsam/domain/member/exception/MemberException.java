package com.example.chunsam.domain.member.exception;

import com.example.chunsam.global.apiPayload.code.BaseErrorCode;
import com.example.chunsam.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }

}
