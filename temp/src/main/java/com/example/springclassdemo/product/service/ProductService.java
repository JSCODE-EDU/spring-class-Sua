package com.example.springclassdemo.product.service;

import com.example.springclassdemo.product.base.exception.ProductNoneExsistsException;
import com.example.springclassdemo.product.base.exception.SameProductNameExsistsException;
import com.example.springclassdemo.product.domain.Product;
import com.example.springclassdemo.product.domain.ProductEntity;
import com.example.springclassdemo.product.dto.ProductDto;
import com.example.springclassdemo.product.repository.ProductRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }
    public List<ProductEntity> findAll() {return productRepository.findAll();}


    // 상품 등록
    public ProductEntity save(ProductDto productDto) {
        ifSameProductNameExsistsException(productDto);
        return productRepository.save(new ProductEntity(productDto.getName(), productDto.getPrice()));  // 등록은 product entity로
//        ProductDto savedProductDto = new ProductDto((product.getId()), product.getName(), product.getPrice());
//        return productEntity;
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

    private void ifProductNoneExsistsException(Long productPrice) {
        if(productRepository.findByPrice(productPrice).isEmpty()){
            throw new ProductNoneExsistsException();
        };
    }

    public ProductEntity findById(int productId, @Nullable String monetaryUnit) {
        ifProductNoneExsistsException(productId);
        ProductEntity productEntity = productRepository.findById(productId).get();
//        ProductDto productDto = new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getPrice());
//        if(monetaryUnit.equals("dollar")){
//            return new Product(productDto.getId() ,productDto.getName(), (long) (productDto.getPrice()/1200.));
//        }
        return productEntity;
    }

    public ProductEntity findByName(String productName, @Nullable String monetaryUnit) {
        ifProductNoneExsistsException(productName);
        ProductEntity productEntity = productRepository.findByName(productName).get();
//        ProductDto productDto = new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getPrice());
//        if(monetaryUnit.equals("dollar")){
//            return new Product(productDto.getId() ,productDto.getName(), (long) (productDto.getPrice()/1200.));
//        }
        return productEntity;  // @Nullable과 npe 해결하던 중
    }

    public List<ProductEntity> findByPrice(Long productPrice) {
        ifProductNoneExsistsException(productPrice);
        List<ProductEntity> productEntities = productRepository.findByPrice(productPrice);
        return productEntities;

    }
}
