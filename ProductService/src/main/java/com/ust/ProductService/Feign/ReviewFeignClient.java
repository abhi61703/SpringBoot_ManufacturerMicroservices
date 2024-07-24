package com.ust.ProductService.Feign;

import com.ust.ProductService.Response.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "review-service")
public interface ReviewFeignClient {
    @GetMapping("/reviews")
    List<Review> getReviewsByProductId(@RequestParam("pid") Long pid);
}
