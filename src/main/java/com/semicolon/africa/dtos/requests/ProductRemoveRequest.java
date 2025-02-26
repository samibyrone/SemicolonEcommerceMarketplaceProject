package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.model.ProductCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class ProductRemoveRequest {

    @Id
    private String ProductId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productStock;
    private ProductCategory productCategory;
}
