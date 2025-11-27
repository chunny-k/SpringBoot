package com.example.chunsam.domain.review.dto.req;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class ReviewGetReq {

    @AllArgsConstructor
    @Getter
    @Setter
    public static class ReviewGetByMeberIdReq {
        private Long memberId;

    }

}
