package com.aem.exercise.romannumeral.dto;

public class HundredExpression extends Expression {


    public String one() {
        return "C";
    }
    public String four() {
        return "CD";
    }
    public String five() {
        return "D";
    }
    public String nine() {
        return "CM";
    }

    @Override
    protected int multiple() {
        return 100;
    }
}
