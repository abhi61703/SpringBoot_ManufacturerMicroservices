package com.ust.ReviewService.Repository;

import com.ust.ReviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByPid(Long pid);
    List<Review> findByUid(Long uid);
}
