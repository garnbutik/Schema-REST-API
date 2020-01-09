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
    public ResponseEntity<Object> handleCourseNotFound(Exception e) {
        return createErrorResponseEntity(e, HttpStatus.NOT_FOUND, "");
    }

    @ExceptionHandler(NoLessonsFoundException.class)
    public ResponseEntity<Object> handleNoLessonsNotFound(Exception e) {
        return createErrorResponseEntity(e, HttpStatus.NOT_FOUND, "");

    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleDateTimeParseException(Exception e){
        return createErrorResponseEntity(e, HttpStatus.BAD_REQUEST,
                "Could not parse date. Check your date format. Should be YYYY-MM-DD");
    }

    @ExceptionHandler(ContextNotFoundException.class)
    public ResponseEntity<Object> handleContextNotFound(Exception e){
        return createErrorResponseEntity(e, HttpStatus.NOT_FOUND, "");
    }

    @ExceptionHandler(CouldNotPostToCanvasException.class)
    public ResponseEntity<Object> handlePostToCanvasError(Exception e) {
        return createErrorResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR,
                "Could not post to Canvas, please check your request");
    }

    private ResponseEntity<Object> createErrorResponseEntity(Exception e, HttpStatus httpStatus, String errorMessage) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        if (errorMessage.isEmpty()) {
            errorResponse.setError(e.getMessage());
        } else {
            errorResponse.setError(errorMessage);
        }
        errorResponse.setStatus(httpStatus.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
