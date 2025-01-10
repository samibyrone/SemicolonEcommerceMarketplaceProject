package com.semicolon.africa.controller;

import com.semicolon.africa.dtos.requests.UserLoginRequest;
import com.semicolon.africa.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.dtos.responses.UserLoginResponse;
import com.semicolon.africa.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/map")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

   @PostMapping("/User-sign-up")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest userRequest) {
        UserRegisterResponse registerResponse = userService.registerUser(userRequest);
        return ResponseEntity.status(OK).body(registerResponse);
    }

    @PostMapping("/User-login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userRequest) {
        UserLoginResponse loginResponse = userService.loginUser(userRequest);
        return ResponseEntity.status(OK).body(loginResponse);
    }
}
