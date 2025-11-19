package com.example.chunsam.domain.mission.dto.res;

import com.example.chunsam.domain.mission.dto.req.MissionReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



public class MissionRes {

    @Getter
    @AllArgsConstructor
    public static class MissionStartRes {
        boolean isSuccess;
    }

}
