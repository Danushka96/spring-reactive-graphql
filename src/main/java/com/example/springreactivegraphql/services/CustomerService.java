package com.example.springreactivegraphql.services;

import com.example.springreactivegraphql.entities.Customer;
import com.example.springreactivegraphql.repositories.CustomerRepository;
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
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> addCustomer(String firstName, String lastName, String email) {
        var customer = new Customer(UUID.randomUUID().toString(), firstName, lastName, email);

        return customerRepository.save(customer);
    }
}
