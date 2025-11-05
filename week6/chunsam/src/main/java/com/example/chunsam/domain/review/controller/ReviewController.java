package com.example.chunsam.domain.review.controller;

import com.example.chunsam.domain.review.dto.ReviewOfferResponse;
import com.example.chunsam.domain.review.entity.Review;
import com.example.chunsam.domain.review.repo.ReviewQueryService;
import com.example.chunsam.domain.review.repo.ReviewRepository;
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
    public void saveReview(@RequestBody Review review) {

        reviewRepository.save(review);
    }
    @GetMapping("/serach")
    public List<ReviewOfferResponse> searchReviews(
            @RequestParam String query,
            @RequestParam String type,
            @PathVariable String id
    ) {

        List<ReviewOfferResponse> result= reviewQueryService.searchReviews(query,type,id);
        return result;

    }


}
