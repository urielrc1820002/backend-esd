package com.crud.controller;


import com.crud.exception.ProfileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfileExceptionController {
    @ExceptionHandler(value= ProfileNotFoundException.class)
    public ResponseEntity<Object> exception(ProfileNotFoundException exception)
    {
        return new ResponseEntity<>("Profile not found", HttpStatus.NOT_FOUND);
    }
}
