package com.example.chunsam.domain.mission.controller;


import com.example.chunsam.domain.mission.dto.LocalMissionOfferListResponse;
import com.example.chunsam.domain.mission.dto.LocalMissionOfferResponse;
import com.example.chunsam.domain.mission.dto.req.MissionReq;
import com.example.chunsam.domain.mission.dto.res.MissionRes;
import com.example.chunsam.domain.mission.enums.MissionStatus;
import com.example.chunsam.domain.mission.repo.MissionRepository;
import com.example.chunsam.domain.mission.service.MissionService;
import com.example.chunsam.global.apiPayload.ApiResponse;
import com.example.chunsam.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {


    private final MissionRepository missionRepository;
    private final MissionService missionService;

    @GetMapping("/area/{localId}/member/{memberId}")
    public ApiResponse<LocalMissionOfferListResponse> getOffers(@PathVariable("localId") Long localId, @PathVariable("memberId") Long memberId) {
        PageRequest pageRequest = PageRequest.of(0, 5);
        List<LocalMissionOfferResponse> lists = missionRepository.findMissionOffersByLocationId(localId, memberId, MissionStatus.BEFORE ,pageRequest).getContent();
        LocalMissionOfferListResponse response = new LocalMissionOfferListResponse(lists);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, response);
    }

    @PostMapping("/{missionId}/member/{memberId}") // 뷰로 부터 미션,유저 ID를 받아서 해당 미션 활성화
    public ApiResponse<MissionRes.MissionStartRes> startMission(@RequestBody MissionReq.MissionStartReq req){

        MissionRes.MissionStartRes response = missionService.startMission(req);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS,response);
    }



}


