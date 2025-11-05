package com.example.chunsam.domain.review.converter;


import com.example.chunsam.domain.member.entity.QMember;
import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.domain.review.entity.QReview;
import com.example.chunsam.domain.store.entity.QRestourant;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import org.springframework.stereotype.Component;

@Component
public class ReviewProjectMapper {

    public ConstructorExpression<ReviewOfferResponse> toReviewOfferResponse(
            QRestourant r, QMember m, QReview rv) {
        return Projections.constructor(
                ReviewOfferResponse.class,
                r.restaurantName,
                m.name,
                rv.star,
                rv.content,
                rv.createAt,
                rv.updateAt
        );
    }
}
