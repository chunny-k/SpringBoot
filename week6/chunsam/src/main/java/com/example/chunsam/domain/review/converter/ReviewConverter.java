package com.example.chunsam.domain.review.converter;


import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.review.dto.req.ReviewCreateReq;
import com.example.chunsam.domain.review.entity.Review;
import com.example.chunsam.domain.store.entity.Restourant;

public class ReviewConverter {

    public static Review toEntity(ReviewCreateReq.ReviewCreateRequest req,
                                  Member member,
                                  Restourant restourant) {

        return Review.builder()
                .member(member)
                .restourant(restourant)
                .star(req.star())
                .content(req.content())
                .build();
    }
}
