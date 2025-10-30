package com.example.chunsam.domain.mission.repo;

import com.example.chunsam.domain.mission.dto.LocalMissionOfferResponse;
import com.example.chunsam.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        select new com.example.chunsam.domain.mission.dto.LocalMissionOfferResponse(
            r.restaurantId,
            r.restaurantName,
            m.givePoint,
            m.validDate
        )
        from Mission m
        join m.memberMissions miss
        join m.restourant r
        join r.location loc
        where loc.localId = :localId
          and miss.issuccess = :status
          and miss.member.Id = :memberId
    """)
    Page<LocalMissionOfferResponse> findMissionOffersByLocationId(@Param("localId") Long localId,
                                                                    @Param("memberId") Long memberId,
                                                                    Pageable pageable);
}


