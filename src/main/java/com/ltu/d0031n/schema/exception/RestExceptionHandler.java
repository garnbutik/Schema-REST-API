package com.ltu.d0031n.schema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Object> handleCourseNotFound(Exception e){

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setError(e.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoLessonsFoundException.class)
    public ResponseEntity<Object> handleNoLessonsNotFound(Exception e){

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setError(e.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleDateTimeParseException(Exception e){
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setError("Could not parse date. Check your date format. Should be YYYY-MM-DD");
        errors.setStatus(HttpStatus.BAD_REQUEST.value());
        errors.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(Exception e){

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setError(e.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

}
