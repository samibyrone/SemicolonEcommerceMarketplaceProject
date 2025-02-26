package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.model.CartItem;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data

public class ShoppingCartRemoveRequest {

    @Id
    private String shoppingCart_id;
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;
}
