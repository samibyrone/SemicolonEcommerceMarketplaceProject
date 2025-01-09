package com.semicolon.africa.exception;

public class EmailOrPasswordDoesNotExist extends RuntimeException {

    public EmailOrPasswordDoesNotExist(String message) {
        super(message);
    }
}
