package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);

    boolean validatePassword(String password);

    Optional <User> findByEmail(String email);
}
