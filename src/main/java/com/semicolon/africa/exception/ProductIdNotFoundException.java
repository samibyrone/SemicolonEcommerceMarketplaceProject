package com.semicolon.africa.exception;

public class ProductIdNotFoundException extends RuntimeException {

    public ProductIdNotFoundException(String message) {
        super(message);
    }
}
