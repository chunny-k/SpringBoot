package com.example.chunsam.domain.member.entity.mapping;

import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.entity.Alerts;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member_alert")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_alert_id")
    private Long memberAlertId;   // 단일 PK

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "watched", nullable = false)
    private Boolean watched;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="member_id")// ERD의 약관ID(FK)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="alerts_id")// ERD의 약관ID(FK)
    private Alerts alerts;

}
