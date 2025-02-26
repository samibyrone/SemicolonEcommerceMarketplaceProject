package com.semicolon.africa.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class UserRegisterResponse {

    @Id
    private String id;
    private String message;
    private String email;
}
