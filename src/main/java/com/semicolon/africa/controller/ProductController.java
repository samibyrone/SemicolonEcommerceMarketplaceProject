package com.semicolon.africa.controller;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.dtos.requests.ProductRemoveRequest;
import com.semicolon.africa.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.dtos.responses.ProductRemoveResponse;
import com.semicolon.africa.dtos.responses.ProductUpdateResponse;
import com.semicolon.africa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProductById{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") String productId) {
        Product productResponse = productService.getProductById(productId);
        return ResponseEntity.status(OK).body(productResponse);
    }

    @GetMapping("/getProductByProductName{productName}")
    public ResponseEntity<?> getProductByProductName(@RequestParam("productName") String productName, @RequestBody ProductRegisterRequest registerRequest) {
        Product productResponse = productService.getProductByProductName(productName, registerRequest);
        return ResponseEntity.status(OK).body(productResponse);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody ProductRegisterRequest newProduct) {
        ProductRegisterResponse products = productService.addProduct(newProduct);
        return ResponseEntity.status(OK).body(products);
    }

    @PutMapping("/updateProduct{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") String productId, @RequestBody ProductUpdatesRequest productUpdates) {
        ProductUpdateResponse productResponse = productService.updateProduct(productId, productUpdates);
        return ResponseEntity.status(OK).body(productResponse);
    }

    @DeleteMapping("/deleteProduct{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId, @RequestBody ProductRemoveRequest removeRequest) {
        ProductRemoveResponse deleteResponse = productService.deleteProduct(productId, removeRequest);
        return ResponseEntity.status(OK).body(deleteResponse);
    }
}
