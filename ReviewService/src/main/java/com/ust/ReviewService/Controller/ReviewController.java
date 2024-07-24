package com.ust.ReviewService.Controller;

import com.ust.ReviewService.Entity.Review;
import com.ust.ReviewService.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public void updateReview(@PathVariable Long id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/product/{pid}")
    public List<Review> getReviewsByProductId(@PathVariable Long pid) {
        return reviewService.getReviewsByProductId(pid);
    }
}
