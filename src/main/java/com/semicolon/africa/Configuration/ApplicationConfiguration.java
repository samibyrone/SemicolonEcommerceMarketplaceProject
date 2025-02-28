package com.semicolon.africa.Configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

        }
    }
}
