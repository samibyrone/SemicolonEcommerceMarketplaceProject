package com.semicolon.africa.exception;

public class InvalidCartItemException extends RuntimeException {

    public InvalidCartItemException(String message) {
        super(message);
    }
}
