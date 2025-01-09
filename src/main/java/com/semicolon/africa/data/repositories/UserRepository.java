package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

//    boolean validatePassword(String password);

    Optional <User> findByEmail(String email);
}
