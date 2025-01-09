package com.semicolon.africa.exception;

public class ShoppingCartIdNotFoundException extends RuntimeException {

    public ShoppingCartIdNotFoundException(String message) {
        super(message);
    }
}
