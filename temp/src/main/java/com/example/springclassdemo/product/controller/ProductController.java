package com.example.springclassdemo.product.controller;

import com.example.springclassdemo.product.base.*;
import com.example.springclassdemo.product.domain.Product;
import com.example.springclassdemo.product.domain.ProductEntity;
import com.example.springclassdemo.product.dto.ProductDto;
import com.example.springclassdemo.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 조회 api - all
    @GetMapping("/all")
    public ResponseEntity findAll(@RequestParam @Nullable final String monetaryUnit) {
        List<ProductEntity> productEntityList = productService.findAll();
        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.READ_PRODUCT, productEntityList), HttpStatus.OK);
    }

    // 상품 조회 api - id
    @GetMapping("/{productId}")
    public ResponseEntity getProductById(@PathVariable int productId, @RequestParam @Nullable final String monetaryUnit) {
        ProductEntity product = productService.findById(productId, monetaryUnit);
        ProductDto productInfo = new ProductDto(product.getId(), product.getName(), product.getPrice());

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.READ_PRODUCT, productInfo), HttpStatus.OK);
    }

    // 상품 조회 api - name
    @GetMapping("/name")
    public ResponseEntity getProductByName(@RequestParam(required = false, defaultValue = "") String name, @RequestParam @Nullable final String monetaryUnit) {
        ProductEntity product = productService.findByName(name, monetaryUnit);
        ProductDto productInfo = new ProductDto(product.getId(), product.getName(), product.getPrice());

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.READ_PRODUCT, productInfo), HttpStatus.OK);
    }

    // 상품 조회 api - price
    @GetMapping("/price")
    public ResponseEntity getProductByPrice(@RequestParam(required = false, defaultValue = "") Long price) {
        List<ProductEntity> productEntityList = productService.findByPrice(price);

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.READ_PRODUCT, productEntityList), HttpStatus.OK);
    }

    // 상품 등록 api
    @PostMapping("")
    public ResponseEntity registerProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.REGISTER_PRODUCT_SUCCESS, productDto), HttpStatus.OK);
    }
}
