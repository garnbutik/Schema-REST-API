package com.ltu.d0031n.schema.exception;

public class ContextNotFoundException extends RuntimeException {

    public ContextNotFoundException(String name) {
        super(String.format("Could not find context with name %s", name));
    }
}
