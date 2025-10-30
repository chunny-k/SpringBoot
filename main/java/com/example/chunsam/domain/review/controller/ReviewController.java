package com.example.chunsam.domain.review.controller;

import com.example.chunsam.domain.review.entity.Review;
import com.example.chunsam.domain.review.repo.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;


    @PostMapping
    public void saveReview(@RequestBody Review review) {

        reviewRepository.save(review);
    }



}
