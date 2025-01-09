package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.model.ProductCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class ProductRegisterRequest {

    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private int productStock;
    private ProductCategory productCategory;
}
