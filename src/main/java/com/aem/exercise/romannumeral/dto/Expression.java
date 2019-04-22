package com.aem.exercise.romannumeral.dto;

public abstract class Expression {

    protected abstract String one();

    protected abstract String four();

    protected abstract String five();

    protected abstract String nine() ;

    protected abstract int multiple();

    public void interpret(Context number) {
        while (number.getInput() - (9 * multiple()) >= 0) {
            number.append(nine());
            number.setInput(number.getInput()-(9 * multiple()));
        }
        while (number.getInput() - (5 * multiple()) >= 0) {
            number.append(five());
            number.setInput(number.getInput()-(5 * multiple()));
        }
        while (number.getInput() - (4 * multiple()) >= 0) {
            number.append(four());
            number.setInput(number.getInput()-(4 * multiple()));
        }
        while (number.getInput() - (1 * multiple()) >= 0) {
            number.append(one());
            number.setInput(number.getInput()-(1 * multiple()));
        }
    }
}
