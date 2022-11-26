package com.crud.controller;

import com.crud.exception.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteExceptionController {
    @ExceptionHandler(value = ClienteNotFoundException.class)
    public ResponseEntity<Object> exception(ClienteNotFoundException exception){
        return new ResponseEntity<>("Cliente not found", HttpStatus.NOT_FOUND);
    }

}
