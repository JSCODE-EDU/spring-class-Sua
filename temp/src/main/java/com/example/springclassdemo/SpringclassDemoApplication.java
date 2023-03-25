package com.example.springclassdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.springclassdemo.product.domain")
public class SpringclassDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringclassDemoApplication.class, args);
    }

}
