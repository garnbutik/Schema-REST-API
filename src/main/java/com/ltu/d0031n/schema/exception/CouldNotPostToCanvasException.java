package com.ltu.d0031n.schema.exception;

public class CouldNotPostToCanvasException extends RuntimeException {

    public CouldNotPostToCanvasException(){
        super("Could not save data to Canvas");
    }
}
