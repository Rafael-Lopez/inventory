package com.thunderbird.inventory.service;

import com.thunderbird.inventory.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
