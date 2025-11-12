package com.example.chunsam.domain.mission.controller;


import com.example.chunsam.domain.mission.dto.LocalMissionOfferListResponse;
import com.example.chunsam.domain.mission.dto.LocalMissionOfferResponse;
import com.example.chunsam.domain.mission.enums.MissionStatus;
import com.example.chunsam.domain.mission.repo.MissionRepository;
import com.example.chunsam.global.apiPayload.ApiResponse;
import com.example.chunsam.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {


    private final MissionRepository missionRepository;

    @GetMapping("/area/{localId}/member/{memberId}")
    public ApiResponse<LocalMissionOfferListResponse> getOffers(@PathVariable("localId") Long localId, @PathVariable("memberId") Long memberId) {
        PageRequest pageRequest = PageRequest.of(0, 5);
        List<LocalMissionOfferResponse> lists = missionRepository.findMissionOffersByLocationId(localId, memberId, MissionStatus.BEFORE ,pageRequest).getContent();
        LocalMissionOfferListResponse response = new LocalMissionOfferListResponse(lists);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, response);
    }
}


