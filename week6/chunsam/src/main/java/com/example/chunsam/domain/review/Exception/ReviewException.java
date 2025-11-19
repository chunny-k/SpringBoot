package com.example.chunsam.domain.review.Exception;

import com.example.chunsam.global.apiPayload.code.BaseErrorCode;
import com.example.chunsam.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
