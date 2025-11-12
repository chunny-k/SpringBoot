package com.example.chunsam.domain.member.dto.res;

import com.example.chunsam.domain.member.enums.Gender;

import java.time.LocalDateTime;
import java.util.Date;

public record MemberResDto(
        Long id,
        String name,
        Gender gender,
        LocalDateTime birthDate,
        String address,
        String detailAddress,
        String phone,
        int point,
        String email,
        String status,
        Date validDate
) {}