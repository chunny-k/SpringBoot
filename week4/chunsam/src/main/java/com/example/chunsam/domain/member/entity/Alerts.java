package com.example.chunsam.domain.member.entity;

import com.example.chunsam.domain.member.entity.mapping.MemberAlert;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "alerts")
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Alerts {

    @OneToMany(mappedBy ="alerts")
    private List<MemberAlert> memberAlert = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alerts_id")
    private Long alertId;

    @Column(name = "alerts", nullable = false)
    private String alert;

}
