package com.aem.exercise.romannumeral.service;

public class TenExpression extends Expression {


    public String one() {
        return "X";
    }
    public String four() {
        return "XL";
    }
    public String five() {
        return "L";
    }
    public String nine() {
        return "XC";
    }

    @Override
    protected int multiple() {
        return 10;
    }
}
