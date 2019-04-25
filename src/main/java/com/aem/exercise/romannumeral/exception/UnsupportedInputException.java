package com.aem.exercise.romannumeral.exception;

public class UnsupportedInputException extends IllegalArgumentException {

    private Long inputValue;

    public Long getInputValue() {
        return inputValue;
    }

    public UnsupportedInputException(Long inputValue) {
        super();
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        return String.format("Input value '%s' is not in the range of accepted values {1 - 2200000000}", inputValue);
    }
}
