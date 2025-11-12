package com.example.chunsam.domain.member.service.query;

import com.example.chunsam.domain.member.converter.MemberConverter;
import com.example.chunsam.domain.member.converter.MemberMissionConverter;
import com.example.chunsam.domain.member.dto.req.MemberMissionReqDto;
import com.example.chunsam.domain.member.dto.req.MemberReqDto;
import com.example.chunsam.domain.member.dto.res.MemberMissionListResponse;
import com.example.chunsam.domain.member.dto.res.MemberResDto;
import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.member.repo.MemberMissionRepository;
import com.example.chunsam.domain.member.repo.MemberRepository;

import com.example.chunsam.domain.mission.enums.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryService {
    final MemberRepository memberRepository;
    final MemberMissionRepository memberMissionRepository;

    public MemberResDto getMember(MemberReqDto.ReqbyId reqbyId) {
        Member mem = memberRepository.findById(reqbyId.getId())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        return MemberConverter.toResDto(mem);
    }

    public MemberMissionListResponse getMemberMissionList(MemberMissionReqDto.ReqbyId reqbyId) {

        List<MemberMission> progressMissions = memberMissionRepository.findByidAndIssuccess(reqbyId.getId(), MissionStatus.IN_PROGRESS);
        List<MemberMission> completeMissions = memberMissionRepository.findByidAndIssuccess(reqbyId.getId(), MissionStatus.COMPLETE);


        return new MemberMissionListResponse(
                MemberMissionConverter.toResponseList(progressMissions),
                MemberMissionConverter.toResponseList(completeMissions)
        );

    }



}
