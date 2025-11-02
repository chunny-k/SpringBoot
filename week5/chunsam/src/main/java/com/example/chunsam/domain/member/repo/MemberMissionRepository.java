package com.example.chunsam.domain.member.repo;

import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.mission.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {



    @Query("select m from MemberMission m where m.id = :id")
    List<MemberMission> findByid(@Param("id") Long id);

    @Query("select m from MemberMission m where m.id = :id and m.issuccess = :status")
    List<MemberMission> findByidAndIssuccess(@Param("id")  Long id,@Param("status") MissionStatus status);

}
