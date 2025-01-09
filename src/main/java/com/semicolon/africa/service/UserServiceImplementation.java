package com.semicolon.africa.service;

import com.semicolon.africa.data.model.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.UserLoginRequest;
import com.semicolon.africa.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.dtos.responses.UserLoginResponse;
import com.semicolon.africa.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.exception.EmailAlreadyExist;
import com.semicolon.africa.exception.EmailOrPasswordDoesNotExist;
import com.semicolon.africa.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.semicolon.africa.utils.Mapper.*;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {
        validateExistingEmail(userRegisterRequest.getEmail());
        User user = new User();
        map(userRegisterRequest, user);
        userRepository.save(user);
        return map(user);
    }

    private void validateExistingEmail(String email) {
        boolean existByEmail = userRepository.existsByEmail(email);
        if (existByEmail) throw new EmailAlreadyExist("Email Already Exist");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(String userId) {
        return Optional.empty();
    }

    @Override
    public UserLoginResponse loginUser(UserLoginRequest userLogin) {
        User user = findByEmail(userLogin.getEmail());
//        validatingPassword(userLogin.getPassword());
        mapLogin(user);
        user.setLoggedIn(true);
        userRepository.save(user);
        return mapLogin(user);
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow( () -> new UserNotFoundException("User does not exist"));
    }
//
//    private void validatingPassword(String password) throws EmailOrPasswordDoesNotExist{
//        boolean validatePassword = userRepository.validatePassword(password);
//        if (!validatePassword)throw new EmailOrPasswordDoesNotExist("Email and Password Does not Exist");
//    }
}
