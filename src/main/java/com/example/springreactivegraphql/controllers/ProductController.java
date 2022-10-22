package com.example.springreactivegraphql.controllers;

import com.example.springreactivegraphql.entities.Customer;
import com.example.springreactivegraphql.entities.Product;
import com.example.springreactivegraphql.repositories.CustomerRepository;
import com.example.springreactivegraphql.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author danushka
 * 2022-10-23
 */
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CustomerRepository customerRepository;

    @QueryMapping
    public Flux<Product> getProducts() {
        return productService.getAllProducts();
    }

    @MutationMapping
    public Mono<Product> addProduct(@Argument String name, @Argument Double price, @Argument int quantity, @Argument String userId) {
        return productService.addProduct(name, price, quantity, userId);
    }

    @BatchMapping
    public Mono<Map<Product, Customer>> customer(List<Product> productList) {
        var customerList = productList.stream().map(Product::getUserId).toList();
        return customerRepository.findAllById(customerList)
                .collect(Collectors.toMap(Customer::getId, customer -> customer))
                .map(customers -> productList.stream()
                        .collect(Collectors.toMap(product -> product, product -> customers.get(product.getUserId()))));
    }
}
