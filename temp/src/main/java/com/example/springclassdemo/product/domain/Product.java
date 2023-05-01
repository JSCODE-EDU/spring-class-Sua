package com.example.springclassdemo.product.domain;

import lombok.Getter;

@Getter
public class Product {
    private String name;
    private Long price;
    private int id;

    public Product(int id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }
    public void setId(int id) {
        this.id = id;
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
