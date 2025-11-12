package com.example.chunsam.domain.member.dto.res;

import com.example.chunsam.domain.mission.enums.MissionStatus;

import java.time.LocalDate;

public record MemberMissionResponse(Long missionId,
                                    Long memberId,
                                    MissionStatus status,
                                    LocalDate validDate
) {}