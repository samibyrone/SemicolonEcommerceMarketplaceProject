package com.semicolon.africa.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data

public class CartItem {

    @Id
    private String cartItem_id;
    private String product_id;
    private String productName;
    private int quantityOfProducts;
    private double price;
    private ProductCategory productcategory;
    private ShoppingCart shoppingCart;
}
