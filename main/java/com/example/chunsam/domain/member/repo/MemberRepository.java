package com.example.chunsam.domain.member.repo;

import com.example.chunsam.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query
    Member findByMemberId(Long memberId);


}
