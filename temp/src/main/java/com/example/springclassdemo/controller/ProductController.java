package com.example.springclassdemo.controller;

import com.example.springclassdemo.domain.Product;
import com.example.springclassdemo.domain.ProductDto;
import com.example.springclassdemo.service.ProductService;
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
    public List<Product> findAll() {
        return productService.findAll();
    }

    // 상품 조회 api - id
    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable int productId) {
        Product product = productService.findById(productId);
        ProductDto productInfo = new ProductDto(product.getId(), product.getName(), product.getPrice());
        return productInfo;
    }

    // 상품 조회 api - name
    @GetMapping("/name")
    public ProductDto getProductByName(@RequestParam(required = false, defaultValue = "") String name) {
        Product product = productService.findByName(name);
        ProductDto productInfo = new ProductDto(product.getId(), product.getName(), product.getPrice());
        return productInfo;
    }

    // 상품 등록 api
    @PostMapping("")
    public ProductDto registerProduct(@RequestBody ProductDto productDto) {
        productService.save(productDto);
        return productDto;
    }
}
