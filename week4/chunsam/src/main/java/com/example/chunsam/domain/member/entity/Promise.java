package com.example.chunsam.domain.member.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "promise")
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Promise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promise_id")
    private Long promiseId;

    @Column(name = "promise", nullable = false)
    private String promise;
}
