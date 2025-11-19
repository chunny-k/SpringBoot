package com.example.chunsam.domain.mission.service;


import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.member.repo.MemberMissionRepository;
import com.example.chunsam.domain.member.repo.MemberRepository;
import com.example.chunsam.domain.mission.Exception.MissionException;
import com.example.chunsam.domain.mission.Exception.code.MissionErrorCode;
import com.example.chunsam.domain.mission.converter.MissionConverter;
import com.example.chunsam.domain.mission.dto.req.MissionReq;
import com.example.chunsam.domain.mission.dto.res.MissionRes;
import com.example.chunsam.domain.mission.entity.Mission;
import com.example.chunsam.domain.mission.repo.MissionRepository;
import com.example.chunsam.domain.review.Exception.ReviewException;
import com.example.chunsam.domain.review.Exception.code.ReviewErrorCode;
import com.example.chunsam.domain.store.entity.Restourant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository missionMissionRepository;



    public MissionRes.MissionStartRes startMission(MissionReq.MissionStartReq req){

        Member member = memberRepository.findById(req.memberId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.No_Mem_EXCEPTION)); // 맴버 있는지 확인

        Mission mission = missionRepository.findById(req.missionId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.No_Mission_EXCEPTION)); // 미션 있는지 확인

        MemberMission missionMission = MissionConverter.MissionStartToEntity(member, mission);

        try {
            missionMissionRepository.save(missionMission);
        } catch (Exception e) {
            throw new MissionException(MissionErrorCode.SAVE_FAILED_EXCEPTION);
        }


        return new MissionRes.MissionStartRes(true);


    }
}
