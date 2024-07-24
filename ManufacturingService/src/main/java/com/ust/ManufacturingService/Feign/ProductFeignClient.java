package com.ust.ManufacturingService.Feign;

import com.ust.ManufacturingService.Response.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductFeignClient {

    @GetMapping("/products/manufacturer/{mid}")
    List<Product> getProductsByManufacturerId(@PathVariable("mid") Long mid);
}
