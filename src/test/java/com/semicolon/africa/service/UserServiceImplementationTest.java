package com.semicolon.africa.service;

import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.UserLoginRequest;
import com.semicolon.africa.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.dtos.responses.UserLoginResponse;
import com.semicolon.africa.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.exception.EmailAlreadyExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceImplementationTest {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanBeRegistered() {
        UserRegisterResponse response = userRegistration();
        System.out.println("Updating contact with ID: " + response);
        assertThat(response).isNotNull();
        assertThat(userServiceImplementation.getAllUsers().size()).isEqualTo(1L);
        assertThat(response.getMessage()).contains("Registered Successfully");
    }

    private UserRegisterResponse userRegistration() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setFirstName("samson");
        request.setLastName("ibironke");
        request.setUserName("Sammy");
        request.setEmail("ibironke@gmail.com");
        request.setPassword("12345");
        request.setPhoneNumber("08187606899");
        request.setRole("CUSTOMER");
        request.setAddress("302, alagomeji bus-stop sabo yaba Lagos");
        UserRegisterResponse response = userServiceImplementation.registerUser(request);
        return response;
    }

    @Test
    public void testThatTwoUsersCanBeRegister() {
        userRegistration();
        UserRegisterRequest request2 = new UserRegisterRequest();
        request2.setFirstName("sammy");
        request2.setLastName("tobi");
        request2.setUserName("Samibyrone");
        request2.setEmail("sammy@gmail.com");
        request2.setPassword("12345");
        request2.setPhoneNumber("08187606891");
        request2.setRole("CUSTOMER");
        request2.setAddress("5th Aveanue festac town");
        UserRegisterResponse response = userServiceImplementation.registerUser(request2);
        assertThat(response).isNotNull();
        assertThrows(EmailAlreadyExist.class, () -> userServiceImplementation.registerUser(request2));
        assertThat(response.getMessage()).contains("Registered Successfully");
        assertThat(userServiceImplementation.getAllUsers().size()).isEqualTo(2L);
    }

    @Test
    public void testThatUserCanNotRegisterTwiceWithTheSameEmail() {
        userRegistration();
        UserRegisterRequest request2 = new UserRegisterRequest();
        request2.setFirstName("2Being");
        request2.setLastName("tobi");
        request2.setUserName("2Being");
        request2.setEmail("ibironke@gmail.com");
        request2.setPassword("12345");
        request2.setPhoneNumber("08187606898");
        request2.setRole("CUSTOMER");
        request2.setAddress("23th Aveanue festac town");
        assertThrows(EmailAlreadyExist.class, () -> userServiceImplementation.registerUser(request2));
        assertThat(userServiceImplementation.getAllUsers().size()).isEqualTo(1L);
    }

    @Test
    public void testThatUserCanLogin() {
        userRegistration();
        UserLoginRequest userLogin = new UserLoginRequest();
        userLogin.setEmail("ibironke@gmail.com");
        userLogin.setPassword("12345");
        UserLoginResponse loginResponse = userServiceImplementation.loginUser(userLogin);
        assertThat(loginResponse).isNotNull();
        assertThat(loginResponse.getMessage()).contains("Logged in Successfully");
        assertThat(loginResponse.isLoggedIn()).isTrue();
    }

//    @Test
//    public void testThatUserCanNotLoginWithWrongPassword() {
//        userRegistration();
//        UserLoginRequest userLogin = new UserLoginRequest();
//        userLogin.setEmail("ibironke@gmail.com");
//        userLogin.setPassword("12345789");
//        UserLoginResponse loginResponse = userServiceImplementation.loginUser(userLogin);
////        assertThrows(EmailOrPasswordDoesNotExist.class, () -> userServiceImplementation.loginUser(userLogin));
//        assertThat(loginResponse).isNotNull();
//        assertThat(loginResponse.getMessage()).contains("Email and Password is Wrong or Does not Exist ");
//        assertThat(loginResponse.isLoggedIn()).isFalse();
//    }

//    @Test
//    public void testThatUserCanBeLoggedOut() {
//        userRegistration();
//        UserLoginRequest userLoggedOut = new UserLoginRequest();
//        userLoggedOut.setEmail("ibironke@gmail.com");
//        userLoggedOut.setPassword("12345");
//        UserLoginResponse loginResponse = userServiceImplementation.loggedOut(userLoggedOut);
//        assertThat(loginResponse).isNotNull();
//        assertThat(loginResponse.getMessage()).contains("You have been Logged Out Successfully");
//        assertThat(loginResponse.isLoggedIn()).isFalse();
//    }

}