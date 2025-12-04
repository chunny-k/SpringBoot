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
import com.example.chunsam.domain.mission.enums.MissionStatus;
import com.example.chunsam.domain.mission.repo.MissionRepository;
import com.example.chunsam.domain.review.Exception.ReviewException;
import com.example.chunsam.domain.review.Exception.code.ReviewErrorCode;
import com.example.chunsam.domain.store.entity.Restourant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository missionMissionRepository;
    private final MemberMissionRepository memberMissionRepository;


    public MissionRes.MissionStartRes startMission
            (MissionReq.MissionStartReq req)
    {

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

    // 가게의 미션들 페이지 단위로 가쟈오기
    public MissionRes.StoreMisssion getStoreMission
    (MissionReq.StoreMission req,int page)
    {

        int pageIndex = page - 1;
        PageRequest pageable = PageRequest.of(pageIndex, 10);
        Page<Mission> missions = missionRepository.findByRestourant_Id(req.storeId(),pageable);


        return MissionConverter.toStoreMission(missions);

    }

    //맴버미션에서 유저 ID와 일치하고 In_Progressing인 Mission들을 찾아서 주기
    public MissionRes.MemberProgressMisssion getMemberProgressMission
            (MissionReq.GetMemberProgressMission req,int page)
    {
        int pageIndex = page - 1;
        PageRequest pageable = PageRequest.of(pageIndex, 10);
        Page<Mission> missions = memberMissionRepository.findMissionsByMissionIdAndStatus
                (req.memberId(), MissionStatus.IN_PROGRESS,pageable);

        return MissionConverter.toMemberProgressMission(missions);


    }
}
