package com.example.chunsam.domain.member.controller;


import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.member.repo.MemberMissionRepository;
import com.example.chunsam.domain.member.repo.MemberRepository;
import com.example.chunsam.domain.mission.entity.Mission;
import com.example.chunsam.domain.mission.enums.MissionStatus;
import com.example.chunsam.domain.mission.repo.MissionRepository;
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

    @GetMapping("/{id}")
    public void getMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id)
                .orElse(null);
    }

    @GetMapping("/{id}/missions")
    public List<MemberMission> getMissions(@PathVariable("id") Long id){


        List<MemberMission> progressMissions = memberMissionRepository.findByMember_IdAndIssuccess(id, MissionStatus.IN_PROGRESS);
        List<MemberMission> completeMissions = memberMissionRepository.findByMember_IdAndIssuccess(id, MissionStatus.COMPLETE);

        return memberMissionRepository.findByMember_Id(id); //일단 이렇게 했는데


    }
}




