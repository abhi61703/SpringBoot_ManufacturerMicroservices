package com.ust.UserService.Feign;


import com.ust.UserService.Response.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "review-service")
public interface ReviewFeignClient {
    @GetMapping("/reviews/user")
    List<Review> getReviewsByUserId(@RequestParam("uid") Long uid);
}
