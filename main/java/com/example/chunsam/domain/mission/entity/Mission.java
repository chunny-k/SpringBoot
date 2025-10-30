package com.example.chunsam.domain.mission.entity;

import com.example.chunsam.domain.member.entity.mapping.MemberMission;
import com.example.chunsam.domain.store.entity.Restourant;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "mission")
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Mission {


    @OneToMany(mappedBy ="mission")
    private List<MemberMission> memberMissions = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long missionId;

    @Column(name = "valid_date")
    private LocalDate validDate;

    @Column(name = "give_point")
    private Integer givePoint;

    @Column(name = "pay", nullable = false)
    private Integer pay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restourant restourant;   //
}
