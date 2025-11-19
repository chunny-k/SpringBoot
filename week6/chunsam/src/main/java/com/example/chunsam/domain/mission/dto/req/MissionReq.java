package com.example.chunsam.domain.mission.dto.req;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MissionReq {

    public record MissionStartReq(
            Long missionId,
            Long memberId
    )
    {}

}
