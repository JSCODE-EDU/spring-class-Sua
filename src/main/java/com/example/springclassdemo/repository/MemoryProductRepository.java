package com.example.springclassdemo.repository;

import com.example.springclassdemo.domain.Product;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository {

    private static Map<Integer, Product> store = new HashMap<>();
    private static int sequence = 0;


    // 상품 저장
    public Product save(Product product) {
        product.setId(++sequence);
        store.put(product.getId(), product);

        return product;
    }

    // 비우기
    public void clearStore(){
        store.clear();
    }

    // 전체 상품을 조회하는 메소드
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    // 특정 상품을 조회하는 메소드 - id
    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    // 특정 상품을 조회하는 메소드 - name
    @Override
    public Optional<Product> findByName(String name) {
        return store.values().stream().filter(product -> product.getName().equals(name)).findAny();
    }
}
