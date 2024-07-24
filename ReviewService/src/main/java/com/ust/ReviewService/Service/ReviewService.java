package com.ust.ReviewService.Service;

import com.ust.ReviewService.Entity.Review;
import com.ust.ReviewService.Feign.ProductFeignClient;
import com.ust.ReviewService.Feign.UserFeignClient;
import com.ust.ReviewService.Repository.ReviewRepository;
import com.ust.ReviewService.Response.Product;
import com.ust.ReviewService.Response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public void updateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if (existingReview != null) {
            existingReview.setUid(review.getUid());
            existingReview.setRdesc(review.getRdesc());
            existingReview.setRrating(review.getRrating());
            existingReview.setPid(review.getPid());
            reviewRepository.save(existingReview);
        }
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Product getProductById(Long pid) {
        return productFeignClient.getProductById(pid);
    }

    public User getUserById(Long uid) {
        return userFeignClient.getUserById(uid);
    }

    public List<Review> getReviewsByProductId(Long pid) {
        return reviewRepository.findByPid(pid);
    }
}
