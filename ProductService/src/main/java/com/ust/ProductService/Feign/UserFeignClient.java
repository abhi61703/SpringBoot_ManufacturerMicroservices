package com.ust.ProductService.Feign;

import com.ust.ProductService.Response.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserFeignClient {
    @GetMapping("/users/{uid}")
    User getUserById(@PathVariable("uid") Long uid);

    @GetMapping("/users/product/{pid}")
    List<User> getUsersByProductId(@PathVariable("pid") Long pid);
}