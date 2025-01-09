package com.semicolon.africa.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class ShoppingCartRegisterRequest {

    @Id
    private String shoppingCart_id;
    private String customerName;
    private List<CartItemRegisterRequest> cartItems = new ArrayList<>();
    private double totalPrice;
}
