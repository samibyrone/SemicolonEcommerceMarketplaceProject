package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.data.model.ProductCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartItemRemoveRequest {

    @Id
    private String cartItem_id;
    private List<Product> products = new ArrayList<>();
    private int quantityOfProducts;
    private ProductCategory productcategory;
}
