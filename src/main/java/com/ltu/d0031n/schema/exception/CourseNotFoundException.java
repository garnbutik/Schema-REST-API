package com.ltu.d0031n.schema.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String courseCode) {
        super(String.format("Could not find course %s", courseCode));
    }
}
