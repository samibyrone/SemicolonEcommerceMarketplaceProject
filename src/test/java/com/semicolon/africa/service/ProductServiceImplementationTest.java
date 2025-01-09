package com.semicolon.africa.service;


import com.semicolon.africa.data.model.ProductCategory;
import com.semicolon.africa.data.repositories.ProductRepository;
import com.semicolon.africa.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.dtos.responses.ProductUpdateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductServiceImplementationTest {

    @Autowired
    private ProductServiceImplementation productServiceImplementation;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testThatProductCanBeAddedToRepository() {
        ProductRegisterResponse productResponse = ProductRegister();
        System.out.println("Updating contact with ID: " +  productResponse);
        assertThat(productResponse).isNotNull();
        assertThat(productResponse.getMessage().contains("Product added successfully"));
        assertThat(productServiceImplementation.getAllProducts().size()).isEqualTo(1L);
    }

    private ProductRegisterResponse ProductRegister() {
        ProductRegisterRequest productRequest = new ProductRegisterRequest();
        productRequest.setProductName("Bread");
        productRequest.setProductDescription("Sliced-Bread");
        productRequest.setProductPrice(1500.0);
        productRequest.setProductStock(2);
        productRequest.setProductCategory(ProductCategory.SUPERMARKET);
        return productServiceImplementation.addProduct(productRequest);
    }

    @Test
    public void testThatProductCanBeUpdatedInTheRepository() {
        ProductRegisterResponse productResponse = ProductRegister();
        String productId = productResponse.getProductId();
        ProductUpdatesRequest updatesRequest = new ProductUpdatesRequest();
        updatesRequest.setProductName("Television-set");
        updatesRequest.setProductDescription("LCD Television-set");
        updatesRequest.setProductPrice(157000.0);
        updatesRequest.setProductStock(20);
        updatesRequest.setProductCategory(ProductCategory.ELECTRONICS);
        ProductUpdateResponse updateResponse = productServiceImplementation.updateProduct(productId, updatesRequest);
        System.out.println("Updating contact with ID: " + updateResponse);
        assertThat(updateResponse).isNotNull();
        assertThat(updateResponse.getMessage()).contains("Product updated successfully");
        assertThat(productServiceImplementation.getAllProducts().size()).isEqualTo(1L);
    }

//    @Test
//    public void testThatProductCanBeRemovedFromRepository() {
//        ProductRegister();
//        ProductRemoveRequest removeRequest = new ProductRemoveRequest();
//        removeRequest.setProductId("225");
//        removeRequest.setProductName("Bread");
//        removeRequest.setProductDescription("Sliced-Bread");
//        removeRequest.setProductPrice(1500.0);
//        removeRequest.setProductStock(1);
//        removeRequest.setProductCategory(ProductCategory.SUPERMARKET);
//        ProductRemoveResponse removeResponse = productServiceImplementation.deleteProduct("225");
//        assertThat(removeResponse.getMessage()).contains("Product removed successfully");
//    }

}