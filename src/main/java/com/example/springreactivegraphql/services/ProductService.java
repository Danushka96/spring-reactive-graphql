package com.example.springreactivegraphql.services;

import com.example.springreactivegraphql.entities.Product;
import com.example.springreactivegraphql.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author danushka
 * 2022-10-22
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> addProduct(String name, Double price, int quantity, String userId) {
        var product = new Product(UUID.randomUUID().toString(), userId, name, price, quantity);

        return productRepository.save(product);
    }
}
