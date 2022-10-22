package com.example.springreactivegraphql.repositories;

import com.example.springreactivegraphql.entities.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author danushka
 * 2022-10-22
 */
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
