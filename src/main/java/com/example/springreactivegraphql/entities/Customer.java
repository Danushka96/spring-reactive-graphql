package com.example.springreactivegraphql.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author danushka
 * 2022-10-22
 */
@Document(collection = "customers")
@AllArgsConstructor
@Data
public class Customer {
    private final String id;
    private String firstName;
    private String lastName;
    private String email;
}
