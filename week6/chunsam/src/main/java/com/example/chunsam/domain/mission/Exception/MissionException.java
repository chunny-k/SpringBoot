package com.example.chunsam.domain.mission.Exception;

import com.example.chunsam.global.apiPayload.code.BaseErrorCode;
import com.example.chunsam.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
