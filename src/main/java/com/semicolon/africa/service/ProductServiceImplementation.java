package com.semicolon.africa.service;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.data.model.User;
import com.semicolon.africa.data.repositories.ProductRepository;
import com.semicolon.africa.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.dtos.requests.ProductRemoveRequest;
import com.semicolon.africa.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.dtos.responses.ProductRemoveResponse;
import com.semicolon.africa.dtos.responses.ProductUpdateResponse;
import com.semicolon.africa.exception.ProductAlreadyExistedException;
import com.semicolon.africa.exception.ProductDoesNotExistException;
import com.semicolon.africa.exception.ProductIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.semicolon.africa.utils.Mapper.*;


@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow( () -> new ProductIdNotFoundException("Product does not exist"));
    }

    @Override
    public Product getProductByProductName(String productName, ProductRegisterRequest registerRequest) {
        return productRepository.findByProductName(productName)
                .orElseThrow( () -> new ProductDoesNotExistException("Product does not exist"));
    }

    @Override
    public ProductRegisterResponse addProduct(ProductRegisterRequest productRegisterRequest) {
        validateProduct(productRegisterRequest.getProductId());
        Product product = new Product();
        mapProduct(productRegisterRequest, product);
        productRepository.save(product);
        System.out.print(product.getProductName());
        return mapProduct(product);
    }

    private void validateProduct(String productId) {
        Optional<User> productValidation = userService.findUserById(productId);
        if (productValidation.isPresent())  throw new ProductAlreadyExistedException("Product Already Existed");
    }

    @Override
    public ProductUpdateResponse updateProduct(String productId, ProductUpdatesRequest productUpdatesRequest) {
        validateProduct(productId);
        Product product = productRepository.findById(productId)
                .orElseThrow( () -> new ProductDoesNotExistException("Product does not exist"));
        if(productId == null || productId.isEmpty()) { throw new ProductIdNotFoundException("Product ID is not Found"); }
        mapProductUpdate(productUpdatesRequest, product);
        Product productUpdated = productRepository.save(product);
        return mapProductUpdate(productUpdated);
    }

    @Override
    public ProductRemoveResponse deleteProduct(String productId, ProductRemoveRequest productRemoveRequest) {
        Optional <Product> productDelete = productRepository.findById(productId);
            if(!productDelete.isPresent()) throw new ProductDoesNotExistException("Product does not exist");
        productRepository.deleteById(productId);
        ProductRemoveResponse response = new ProductRemoveResponse();
        response.setMessage("Product Successfully Deleted");
        return response;

    }

}
