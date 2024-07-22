package com.ust.ProductService.Service;

import com.ust.ProductService.Entity.Product;
import com.ust.ProductService.Feign.ReviewFeignClient;
import com.ust.ProductService.Feign.UserFeignClient;
import com.ust.ProductService.Repository.ProductRepository;
import com.ust.ProductService.Response.Review;
import com.ust.ProductService.Response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private ReviewFeignClient reviewFeignClient;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setPname(product.getPname());
            existingProduct.setPrating(product.getPrating());
            existingProduct.setPprice(product.getPprice());
            existingProduct.setMid(product.getMid());
            productRepository.save(existingProduct);
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public User getUserById(Long uid) {
        return userFeignClient.getUserById(uid);
    }

    public List<Review> getReviewsByProductId(Long pid) {
        return reviewFeignClient.getReviewsByProductId(pid);
    }

    public List<Product> getProductsByManufacturerId(Long mid) {
        return productRepository.findByMid(mid);
    }

    public List<User> getUsersByProductId(Long pid) {
        return userFeignClient.getUsersByProductId(pid);
    }
}
