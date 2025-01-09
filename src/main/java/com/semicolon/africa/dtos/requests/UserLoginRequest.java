package com.semicolon.africa.dtos.requests;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class UserLoginRequest {

    private String email;
    private String password;
}
