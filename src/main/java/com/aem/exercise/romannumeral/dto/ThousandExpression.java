package com.aem.exercise.romannumeral.dto;

public class ThousandExpression extends Expression {

    protected String one() {
        return "M";
    }
    protected String four() {
        return "IV&#773;";
    }
    protected String five() {
        return "V&#773;";
    }
    protected String nine() {
        return "IX&#773;";
    }

    protected int multiple() {
        return 1000;
    }

}
