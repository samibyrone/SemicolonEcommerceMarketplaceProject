package com.semicolon.africa.dtos.requests;

import lombok.Data;

@Data

public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String role;
}
