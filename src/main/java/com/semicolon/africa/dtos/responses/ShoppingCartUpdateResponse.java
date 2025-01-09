package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class ShoppingCartUpdateResponse {

    @Id
    private String shoppingCartId;
    private String message;
}
