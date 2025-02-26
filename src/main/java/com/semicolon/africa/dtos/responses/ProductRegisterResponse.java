package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class ProductRegisterResponse {

    @Id
    private String productId;
    private String message;
}
