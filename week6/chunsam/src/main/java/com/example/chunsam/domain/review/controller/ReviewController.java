package com.example.chunsam.domain.review.controller;

import com.example.chunsam.domain.review.dto.ReviewOfferListResponse;
import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.domain.review.dto.ReviewUpdateReq;
import com.example.chunsam.domain.review.dto.req.ReviewCreateReq;
import com.example.chunsam.domain.review.dto.res.ReviewCreateRes;
import com.example.chunsam.domain.review.entity.Review;
import com.example.chunsam.domain.review.repo.ReviewQueryService;
import com.example.chunsam.domain.review.repo.ReviewRepository;
import com.example.chunsam.domain.review.service.ReviewService;
import com.example.chunsam.global.apiPayload.ApiResponse;
import com.example.chunsam.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//wsl2

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewService reviewService;


    @PostMapping
    public ApiResponse<ReviewCreateRes> saveReview(@RequestBody ReviewCreateReq.ReviewCreateRequest request) {

        ReviewCreateRes res = reviewService.ReviewCreate(request);

        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS,res);
    }

    @GetMapping("/serach")
    public ApiResponse<ReviewOfferListResponse> searchReviews(
            @RequestParam String query,
            @RequestParam String type,
            @PathVariable String id
    ) {

        List<ReviewOfferResponse> result= reviewQueryService.searchReviews(query,type,id);
        ReviewOfferListResponse response = new ReviewOfferListResponse(result);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS,response);

    }


}
