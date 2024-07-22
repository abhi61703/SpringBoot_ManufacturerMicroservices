package com.ust.ReviewService.Feign;


import com.ust.ReviewService.Response.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserFeignClient {
    @GetMapping("/users/{uid}")
    User getUserById(@PathVariable("uid") Long uid);
}