package com.thunderbird.inventory.controller;

import com.thunderbird.inventory.entity.Product;
import com.thunderbird.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

}
