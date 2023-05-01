package com.example.springclassdemo.product.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Getter
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Long price;

    public ProductEntity(String name, Long price) {
        this.name = name;
        this.price = price;
    }
}
