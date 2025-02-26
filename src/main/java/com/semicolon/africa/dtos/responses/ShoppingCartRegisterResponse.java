package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class ShoppingCartRegisterResponse {

    @Id
    private String shoppingCart_id;
    private String message;
}
