package com.example.baitapquanlysanphammvc.service;

import com.example.baitapquanlysanphammvc.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(String id);
    void update(Product product);
    List<Product> findByName(String name);
    Product findById(String id);
    List<Product> findAll();
}
