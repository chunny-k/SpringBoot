package com.example.chunsam.domain.member.converter;

import com.example.chunsam.domain.member.dto.res.MemberMissionResponse;
import com.example.chunsam.domain.member.entity.mapping.MemberMission;

import java.util.List;

public class MemberMissionConverter {

    public static MemberMissionResponse toResponse(MemberMission mm) {
        return new MemberMissionResponse(
                mm.getId(),
                mm.getMission().getId(),
                mm.getIssuccess(),
                mm.getSuccessDate()
        );
    }

    public static List<MemberMissionResponse> toResponseList(List<MemberMission> list) {
        return list.stream()
                .map(MemberMissionConverter::toResponse)
                .toList();
    }

}
