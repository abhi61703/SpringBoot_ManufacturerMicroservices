package com.ust.ReviewService.Repository;

import com.ust.ReviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
