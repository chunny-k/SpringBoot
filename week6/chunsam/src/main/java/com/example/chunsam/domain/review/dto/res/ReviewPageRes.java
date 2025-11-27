package com.example.chunsam.domain.review.dto.res;

import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.global.PageInfo;

import java.util.List;

public record ReviewPageRes(
        List<ReviewOfferResponse> reviews,
        PageInfo pageInfo
) {}