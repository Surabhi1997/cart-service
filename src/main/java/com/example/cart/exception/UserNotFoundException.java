package com.example.cart.exception;

public class UserNotFoundException extends RuntimeException{
    private String message;

    public UserNotFoundException() {
    }

    public UserNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
