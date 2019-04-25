package com.aem.exercise.romannumeral.controller;

import com.aem.exercise.romannumeral.exception.UnsupportedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(UnsupportedInputException.class)
    ResponseEntity<String> handleUnSupportedInputException(UnsupportedInputException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.toString());
    }

    @ExceptionHandler(NumberFormatException.class)
    ResponseEntity<String> handleNumberFormatException(NumberFormatException exception) {
        return ResponseEntity
                .badRequest()
                .body("Unsupported Format - Accepted values are {1-2200000000}");
    }

}
