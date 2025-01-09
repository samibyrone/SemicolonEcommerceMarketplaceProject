package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.dtos.requests.ProductRemoveRequest;
import com.semicolon.africa.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.dtos.responses.ProductRemoveResponse;
import com.semicolon.africa.dtos.responses.ProductUpdateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    Product getProductByProductName(String product_name, ProductRegisterRequest registerRequest);

    ProductRegisterResponse addProduct(ProductRegisterRequest productRegisterRequest);

    ProductUpdateResponse updateProduct(String productId, ProductUpdatesRequest productUpdatesRequest);

    ProductRemoveResponse deleteProduct(String productId, ProductRemoveRequest productRemoveRequest);
}
