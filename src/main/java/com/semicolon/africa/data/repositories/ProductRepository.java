package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    boolean existsByProductName(String productName);

    Product findByProductId(String productId);

    Optional<Product> findByProductName(String productName);
}
