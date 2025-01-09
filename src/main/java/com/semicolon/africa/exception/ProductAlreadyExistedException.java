package com.semicolon.africa.exception;

public class ProductAlreadyExistedException extends RuntimeException {

    public ProductAlreadyExistedException(String message) {
        super(message);
    }
}
