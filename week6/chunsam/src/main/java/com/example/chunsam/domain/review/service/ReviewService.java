package com.example.chunsam.domain.review.service;


import com.example.chunsam.domain.member.entity.Member;
import com.example.chunsam.domain.member.repo.MemberRepository;
import com.example.chunsam.domain.review.Exception.ReviewException;
import com.example.chunsam.domain.review.Exception.code.ReviewErrorCode;
import com.example.chunsam.domain.review.converter.ReviewConverter;
import com.example.chunsam.domain.review.dto.req.ReviewCreateReq;
import com.example.chunsam.domain.review.dto.res.ReviewCreateRes;
import com.example.chunsam.domain.review.entity.Review;
import com.example.chunsam.domain.review.repo.ReviewRepository;
import com.example.chunsam.domain.store.entity.Restourant;
import com.example.chunsam.domain.store.repo.RestourantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestourantRepository restourantRepository;


    public ReviewCreateRes ReviewCreate(ReviewCreateReq.ReviewCreateRequest request) {


        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.No_Mem_EXCEPTION)); // 맴버 있는지 확인

        Restourant restourant = restourantRepository.findById(request.restaurantId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.No_Resto_EXCEPTION)); // 가게 있는지 확인

        Review review = ReviewConverter.toEntity(request, member, restourant); // 리뷰 객체 생성

        try {
            reviewRepository.save(review);
        } catch (Exception e) {
            throw new ReviewException(ReviewErrorCode.SAVE_FAILED_EXCEPTION);
        }

        return new ReviewCreateRes(true);
    }


}
