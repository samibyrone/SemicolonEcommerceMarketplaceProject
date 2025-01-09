package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CartItemUpdateResponse {

    @Id
    private String cartItem_id;
    private String message;
}
