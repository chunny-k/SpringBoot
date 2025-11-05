package com.example.chunsam.domain.review.repo;

import com.example.chunsam.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> , ReviewQueryDsl {






}
