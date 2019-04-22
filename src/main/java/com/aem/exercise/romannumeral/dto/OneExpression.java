package com.aem.exercise.romannumeral.dto;

public class OneExpression extends Expression {

    public String one() {
        return "I";
    }
    public String four() {
        return "IV";
    }
    public String five() {
        return "V";
    }
    public String nine() {
        return "IX";
    }

    @Override
    protected int multiple() {
        return 1;
    }
}
