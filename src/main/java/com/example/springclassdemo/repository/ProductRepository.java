package com.example.springclassdemo.repository;

import com.example.springclassdemo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Integer id);
    Optional<Product> findByName(String name);
    List<Product> findAll();
}
