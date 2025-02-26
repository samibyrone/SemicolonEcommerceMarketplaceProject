package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class ShoppingCartUpdateResponse {

    @Id
    private String shoppingCartId;
    private String message;
}
