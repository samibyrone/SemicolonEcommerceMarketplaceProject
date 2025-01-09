//package com.semicolon.africa.controller;
//
//import com.semicolon.africa.data.model.Product;
//import com.semicolon.africa.dtos.requests.ProductRegisterRequest;
//import com.semicolon.africa.dtos.requests.ProductUpdatesRequest;
//import com.semicolon.africa.dtos.responses.ProductRegisterResponse;
//import com.semicolon.africa.dtos.responses.ProductUpdateResponse;
//import com.semicolon.africa.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static com.semicolon.africa.utils.Mapper.mapProduct;
//import static org.springframework.http.HttpStatus.OK;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
////
////    @Autowired
////    private ProductService productService;
////
////    @GetMapping
////    public List<Product> getAllProducts() {
////        return productService.getAllProducts();
////    }
////
////    @GetMapping("/{product_id}")
////    public ResponseEntity<ProductRegisterResponse> getProductById(@PathVariable String product_id) {
////        var product = productService.getProductById(product_id);
////        ProductRegisterResponse  response = mapProduct(product);
////        return ResponseEntity.status(OK).body(response);
////    }
////
////    @PostMapping
////    public ResponseEntity<ProductRegisterResponse> createProduct(@RequestBody ProductRegisterRequest product) {
////        ProductRegisterResponse newProduct = productService.addProduct(product);
////        return ResponseEntity.status(OK).body(newProduct);
////    }
////
////    @PutMapping("/{product_id}")
////    public ResponseEntity<ProductUpdateResponse> updateProduct(@PathVariable String product_id, @RequestBody ProductUpdatesRequest productUpdates) {
////        ProductUpdateResponse productResponse = productService.updateProduct(product_id, productUpdates);
////        return ResponseEntity.status(OK).body(productResponse);
////    }
////
////    @DeleteMapping("/{product_id}")
////    public ResponseEntity<Void> deleteProduct(@PathVariable String product_id) {
////        productService.deleteProduct(product_id);
////        return ResponseEntity.status(OK).build();
////    }
//
////}
