package com.aem.exercise.romannumeral.dto;

public class Context {

    private long input;
    private StringBuilder output;


    public long getInput() {
        return input;
    }

    public void setInput(long input) {
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
