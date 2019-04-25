package com.aem.exercise.romannumeral.controller;

import com.aem.exercise.romannumeral.exception.UnsupportedInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(UnsupportedInputException.class)
    ResponseEntity<String> handleUnSupportedInputException(UnsupportedInputException exception) {
        LOGGER.error("Unsupported Input - ", exception);
        return ResponseEntity
                .badRequest()
                .body(exception.toString());
    }

    @ExceptionHandler(NumberFormatException.class)
    ResponseEntity<String> handleNumberFormatException(NumberFormatException exception) {
        LOGGER.error("Unsupported Input format - ", exception);
        return ResponseEntity
                .badRequest()
                .body("Unsupported Format - Accepted values are {1-2200000000}");
    }

}
