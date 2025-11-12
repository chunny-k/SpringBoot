package com.example.chunsam.domain.member.controller;


import com.example.chunsam.domain.member.dto.req.MemberMissionReqDto;
import com.example.chunsam.domain.member.dto.req.MemberReqDto;
import com.example.chunsam.domain.member.dto.res.MemberMissionListResponse;
import com.example.chunsam.domain.member.dto.res.MemberMissionResDto;
import com.example.chunsam.domain.member.dto.res.MemberResDto;
import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.member.repo.MemberMissionRepository;
import com.example.chunsam.domain.member.repo.MemberRepository;
import com.example.chunsam.domain.member.service.query.MemberQueryService;
import com.example.chunsam.domain.mission.entity.Mission;
import com.example.chunsam.domain.mission.enums.MissionStatus;
import com.example.chunsam.domain.mission.repo.MissionRepository;
import com.example.chunsam.global.apiPayload.ApiResponse;
import com.example.chunsam.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberQueryService memberQueryService;

    @GetMapping("/{id}")
    public ApiResponse<MemberResDto> getMember(@PathVariable("id") Long id){
        MemberReqDto.ReqbyId req = MemberReqDto.ReqbyId.builder()
                .id(id)
                .build();


        MemberResDto response = memberQueryService.getMember(req);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, response);


    }

    @GetMapping("/{id}/missions")
    public ApiResponse<MemberMissionListResponse> getMissions(@PathVariable("id") Long id){
        MemberMissionReqDto.ReqbyId req = MemberMissionReqDto.ReqbyId.builder()
                .id(id)
                .build();

        MemberMissionListResponse response = memberQueryService.getMemberMissionList(req);

        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS,response); //일단 이렇게 했는데


    }
}




