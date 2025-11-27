package com.example.chunsam.domain.mission.dto.res;

import com.example.chunsam.domain.mission.dto.MissionSummaryRes;
import com.example.chunsam.domain.mission.dto.req.MissionReq;
import com.example.chunsam.domain.mission.entity.Mission;
import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.global.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class MissionRes {

    @Getter
    @AllArgsConstructor
    public static class MissionStartRes {
        boolean isSuccess;
    }

    public record StoreMisssion(
            List<MissionSummaryRes> missions,
            PageInfo pageInfo
    ) { }

    public record MemberProgressMisssion(
            List<MissionSummaryRes> missions,
            PageInfo pageInfo
    ){}
}
