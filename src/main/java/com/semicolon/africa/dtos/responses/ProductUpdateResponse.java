package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class ProductUpdateResponse {

    @Id
    private String productId;
    private String message;
}
