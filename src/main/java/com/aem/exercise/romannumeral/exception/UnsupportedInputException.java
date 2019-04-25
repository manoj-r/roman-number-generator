package com.aem.exercise.romannumeral.exception;

public class UnsupportedInputException extends IllegalArgumentException {

    private String inputValue;

    public String getInputValue() {
        return inputValue;
    }

    public UnsupportedInputException(String inputValue) {
        super();
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        return String.format("Input value '%s' is not in the range of accepted values {1 - 2200000000}", inputValue);
    }
}
