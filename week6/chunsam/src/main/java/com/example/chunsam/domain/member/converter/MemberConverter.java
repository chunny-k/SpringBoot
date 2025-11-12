package com.example.chunsam.domain.member.converter;

import com.example.chunsam.domain.member.dto.res.MemberResDto;
import com.example.chunsam.domain.member.entity.Member;

public class MemberConverter {

    public static MemberResDto toResDto(Member m) {
        return new MemberResDto(
                m.getId(),
                m.getName(),
                m.getGender(),
                m.getBirthDate(),
                m.getAdress(),         // 엔티티는 'adress' 오타 → DTO는 address로
                m.getDetailAddress(),
                m.getPhone(),
                m.getPoint(),
                m.getEmail(),
                m.getStatus(),
                m.getVaildate()        // 엔티티는 'vaildate' 오타 → DTO는 validDate로
        );
        // 가능하면 엔티티 필드명을 address/validDate로 고치는 걸 강력 추천!
    }




}
