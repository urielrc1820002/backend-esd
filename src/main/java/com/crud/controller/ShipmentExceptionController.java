package com.crud.controller;

import com.crud.exception.ShipmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShipmentExceptionController {
    @ExceptionHandler(value = ShipmentNotFoundException.class)
    public ResponseEntity<Object> exception(ShipmentNotFoundException exception)
    {
        return new ResponseEntity<>("Shipment not found", HttpStatus.NOT_FOUND);
    }
}
