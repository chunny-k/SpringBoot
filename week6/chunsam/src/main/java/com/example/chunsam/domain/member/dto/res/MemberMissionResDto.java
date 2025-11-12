package com.example.chunsam.domain.member.dto.res;

import com.example.chunsam.domain.mission.enums.MissionStatus;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class MemberMissionResDto {
    static private Long mission_id;
    static private Long member_id;
    static private MissionStatus issuccess;   // BEFORE / IN_PROGRESS / COMPLETED
    static private LocalDate successDate;

}
