package com.example.chunsam.domain.member.dto.res;

import java.util.List;

public record MemberMissionListResponse(
        List<MemberMissionResponse> progressMissions,
        List<MemberMissionResponse> completeMissions
) {}