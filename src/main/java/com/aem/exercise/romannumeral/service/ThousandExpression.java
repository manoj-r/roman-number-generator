package com.aem.exercise.romannumeral.service;

public class ThousandExpression extends Expression {

    protected String one() {
        return "M";
    }
    protected String four() { return ""; }
    protected String five() {
        return "";
    }
    protected String nine() {
        return "";
    }

    protected int multiple() {
        return 1000;
    }

}
