package com.example.springclassdemo.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private Long price;

    private int id;

    public ProductDto(int id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() { return name; }

    public void setPrice(Long price) {
        this.price = price;
    }
    public Long getPrice() { return price; }
}
