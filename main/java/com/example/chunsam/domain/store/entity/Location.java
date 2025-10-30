package com.example.chunsam.domain.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "location")
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Location {

    @OneToOne(mappedBy = "location")
    private Restourant restourant;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    @Column(name = "local", nullable = false)
    private String local;
}
