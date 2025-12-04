package com.example.chunsam.domain.member.repo;

import com.example.chunsam.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    Optional<Member> findByUserId(String username);

    boolean existsByUserId(String username);


}
