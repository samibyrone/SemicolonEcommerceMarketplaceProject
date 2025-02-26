package com.semicolon.africa.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class Payment {

    @Id
    private int payment_id;
    private int order_id;
    private double amount;
    private String status;
}
