package com.example.chunsam.domain.member.repo;

import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.mission.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    List<MemberMission> findByMember_Id(Long memberId);
    List<MemberMission> findByMember_IdAndIssuccess(Long memberId, MissionStatus status);

}
