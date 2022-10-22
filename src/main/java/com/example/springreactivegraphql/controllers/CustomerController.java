package com.example.springreactivegraphql.controllers;

import com.example.springreactivegraphql.entities.Customer;
import com.example.springreactivegraphql.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author danushka
 * 2022-10-22
 */
@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @QueryMapping
    public Flux<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @MutationMapping
    public Mono<Customer> addCustomer(@Argument String firstName, @Argument String lastName, @Argument String email) {
        return customerService.addCustomer(firstName, lastName, email);
    }
}
