package com.example.chunsam.domain.review.repo;

import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {


    List<ReviewOfferResponse> searchReviews(Predicate predicate);


}
