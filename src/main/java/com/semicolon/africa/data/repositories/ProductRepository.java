package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    boolean existsByProductName(String productName);

    Product findByProductId(String productId);

    Optional<Product> findByProductName(String productName);
}
