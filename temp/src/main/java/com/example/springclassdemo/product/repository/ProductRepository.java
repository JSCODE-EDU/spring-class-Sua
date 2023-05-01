package com.example.springclassdemo.product.repository;

import com.example.springclassdemo.product.domain.Product;
import com.example.springclassdemo.product.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
//    ProductEntity save(Product product);
//    Optional<Product> findById(Integer id);
    Optional<ProductEntity> findByName(String name);
    List<ProductEntity> findByPrice(Long price);
//    List<Product> findAll();
}
