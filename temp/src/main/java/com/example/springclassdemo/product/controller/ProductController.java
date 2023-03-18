package com.example.springclassdemo.product.controller;

import com.example.springclassdemo.product.base.*;
import com.example.springclassdemo.product.domain.Product;
import com.example.springclassdemo.product.dto.ProductDto;
import com.example.springclassdemo.product.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
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
    public List<Product> findAll() {
        return productService.findAll();
    }

    // 상품 조회 api - id
    @GetMapping("/{productId}")
    public ResponseEntity getProductById(@PathVariable int productId) {
        Product product = productService.findById(productId);
        ProductDto productInfo = new ProductDto(product.getId(), product.getName(), product.getPrice());

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.READ_PRODUCT, productInfo), HttpStatus.OK);
    }

    // 상품 조회 api - name
    @GetMapping("/name")
    public ResponseEntity getProductByName(@RequestParam(required = false, defaultValue = "") String name) {
        Product product = productService.findByName(name);
        ProductDto productInfo = new ProductDto(product.getId(), product.getName(), product.getPrice());

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.READ_PRODUCT, productInfo), HttpStatus.OK);
    }

    // 상품 등록 api
    @PostMapping("")
    public ResponseEntity registerProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);

        return new ResponseEntity(BaseResponse.response(StatusCode.OK, ResponseMessage.REGISTER_PRODUCT_SUCCESS, productDto), HttpStatus.OK);
    }
}
