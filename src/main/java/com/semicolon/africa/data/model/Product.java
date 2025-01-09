package com.semicolon.africa.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Data
@Document
public class Product {

    @Id
    private String ProductId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private int productStock;
    private ProductCategory productCategory;
}
