package com.ltu.d0031n.schema.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String name) {
        super(String.format("Could not find user with name %s", name));
    }
}
