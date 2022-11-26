package com.crud.controller;

import com.crud.exception.TrackingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackingExceptionController {
    @ExceptionHandler(value = TrackingNotFoundException.class)
    public ResponseEntity<Object> exception(TrackingNotFoundException exception)
    {
        return new ResponseEntity<>("Tracking not found", HttpStatus.NOT_FOUND);
    }
}
