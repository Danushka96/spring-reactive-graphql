package com.example.springreactivegraphql.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author danushka
 * 2022-10-22
 */
@Document(collection = "products")
@Data
@AllArgsConstructor
public class Product {
    private final String id;
    private final String userId;
    private String name;
    private double price;
    private int quantity;
}
