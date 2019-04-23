package com.aem.exercise.romannumeral.dto;

public class Context {

    private int input;
    private StringBuilder output;


    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public String getOutputValue() {
        return output.toString();
    }

    public void append(Object output) {
        if (null == this.output ) {
            this.output = new StringBuilder();
        }
        this.output.append(output);
    }
}
