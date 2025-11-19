package com.example.chunsam.domain.mission.converter;

import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.mission.entity.Mission;
import com.example.chunsam.domain.mission.enums.MissionStatus;

public class MissionConverter {

    public static MemberMission MissionStartToEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .issuccess(MissionStatus.IN_PROGRESS) // 자동 설정
                .successDate(null)                   // 아직 없음
                .build();
    }
}
