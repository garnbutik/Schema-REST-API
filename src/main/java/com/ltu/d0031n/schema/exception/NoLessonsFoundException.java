package com.ltu.d0031n.schema.exception;

public class NoLessonsFoundException extends RuntimeException{

    public NoLessonsFoundException(String courseCode, String startDate, String endDate) {
        super(String.format("No lessons found for course: %s between dates %S and %s",
                courseCode, startDate, endDate));
    }
}
