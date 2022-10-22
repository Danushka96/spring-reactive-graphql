package com.example.springreactivegraphql.repositories;

import com.example.springreactivegraphql.entities.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author danushka
 * 2022-10-22
 */
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
