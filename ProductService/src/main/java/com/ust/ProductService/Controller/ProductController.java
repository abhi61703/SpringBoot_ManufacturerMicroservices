package com.ust.ProductService.Controller;

import com.ust.ProductService.Entity.Product;
import com.ust.ProductService.Response.User;
import com.ust.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/manufacturer/{mid}")
    public List<Product> getProductsByManufacturerId(@PathVariable Long mid) {
        return productService.getProductsByManufacturerId(mid);
    }

    @GetMapping("/{pid}/users")
    public List<User> getUsersByProductId(@PathVariable Long pid) {
        return productService.getUsersByProductId(pid);
    }

}
