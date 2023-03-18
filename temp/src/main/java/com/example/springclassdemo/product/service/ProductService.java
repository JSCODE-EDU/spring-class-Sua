package com.example.springclassdemo.product.service;

import com.example.springclassdemo.product.base.exception.ProductNoneExsistsException;
import com.example.springclassdemo.product.base.exception.SameProductNameExsistsException;
import com.example.springclassdemo.product.domain.Product;
import com.example.springclassdemo.product.dto.ProductDto;
import com.example.springclassdemo.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // 상품 등록
    public ProductDto save(ProductDto productDto) {
        ifSameProductNameExsistsException(productDto);
        Product product = new Product(productDto.getName(), productDto.getPrice());
        productRepository.save(product);  // 등록은 product entity로
        ProductDto savedProductDto = new ProductDto((product.getId()), product.getName(), product.getPrice());
        return savedProductDto;
    }

    private void ifSameProductNameExsistsException(ProductDto productDto) {
        productRepository.findByName(productDto.getName())
                .ifPresent(m -> {
                    throw new SameProductNameExsistsException();
                });
    }

    private void ifProductNoneExsistsException(String productName) {
        if(productRepository.findByName(productName).isEmpty()){
            throw new ProductNoneExsistsException();
        };

    }

    private void ifProductNoneExsistsException(int productId) {
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNoneExsistsException();
        };
    }

    public Product findById(int productId) {
        ifProductNoneExsistsException(productId);
        return productRepository.findById(productId).get();
    }

    public Product findByName(String productName) {
        ifProductNoneExsistsException(productName);
        return productRepository.findByName(productName).get();
    }
}
