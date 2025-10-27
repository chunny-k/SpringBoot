package com.example.umc9th.domain.store.entity;

import com.example.umc9th.domain.store.entity.Location;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "store")

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "information", nullable = false)
    private String information;

    @Column(name = "manger_number", nullable = false)
    private String manger_number;
}