package com.semicolon.africa.service;

import com.semicolon.africa.data.model.User;
import com.semicolon.africa.dtos.requests.UserLoginRequest;
import com.semicolon.africa.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.dtos.responses.UserLoginResponse;
import com.semicolon.africa.dtos.responses.UserRegisterResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest);

    List<User> getAllUsers();

    Optional<User> findUserById(String userId);

    UserLoginResponse loginUser(UserLoginRequest userLogin);
}
