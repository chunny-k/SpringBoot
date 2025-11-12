package com.example.chunsam.domain.review.controller;

import com.example.chunsam.domain.review.dto.ReviewOfferListResponse;
import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.domain.review.dto.ReviewUpdateReq;
import com.example.chunsam.domain.review.entity.Review;
import com.example.chunsam.domain.review.repo.ReviewQueryService;
import com.example.chunsam.domain.review.repo.ReviewRepository;
import com.example.chunsam.global.apiPayload.ApiResponse;
import com.example.chunsam.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final ReviewQueryService reviewQueryService;


    @PostMapping
    public ApiResponse<ReviewUpdateReq> saveReview(@RequestBody Review review) {

        reviewRepository.save(review);

        ReviewUpdateReq reviewUpdateReq = new ReviewUpdateReq();
        reviewUpdateReq.setSuccess("저장 성공");
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS,reviewUpdateReq);
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
