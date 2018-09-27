package com.example.store.products;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/api/products")
    @PreAuthorize("hasRole('USER')")
    public List<Product> getProductsList() {
        return productService.getProducts();
    }

    public List<Product> fallback() {
        return new ArrayList<>();
    }
}
