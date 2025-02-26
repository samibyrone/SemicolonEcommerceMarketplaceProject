package com.semicolon.africa.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data

public class ShoppingCart {

    @Id
    private String shoppingCart_id;
    private String customerName;
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;
}
