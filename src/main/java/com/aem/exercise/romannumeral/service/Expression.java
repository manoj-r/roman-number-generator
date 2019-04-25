package com.aem.exercise.romannumeral.service;

import com.aem.exercise.romannumeral.dto.Context;

public abstract class Expression {

    protected abstract String one();

    protected abstract String four();

    protected abstract String five();

    protected abstract String nine();

    protected abstract int multiple();

    public static char OVERLINE = '\u0305';

    public static char VINCULAR_POWER = '|';


    /**
     * This method compares input number to value of grammar (--e.g: 9 * multiple()- based on the subclass/type of expression)
     * multiplied by 100000 and reduces the value for each iteration and adds vincular with bracket to output value
     *
     * @param number
     */
    public void superVinculize(Context number) {
        if (!nine().isEmpty()) {
            while (number.getInput() - (9 * multiple() * 100000) >= 0) {
                number.append(VINCULAR_POWER);
                number.append(nine().charAt(0));
                number.append(OVERLINE);
                number.append(nine().charAt(1));
                number.append(OVERLINE);
                number.append(VINCULAR_POWER);
                number.setInput(number.getInput() - (9 * multiple() * 100000));
            }
        }
        if (!five().isEmpty()) {
            while (number.getInput() - (5 * multiple() * 100000) >= 0) {
                number.append(VINCULAR_POWER);
                number.append(five());
                number.append(OVERLINE);
                number.append(VINCULAR_POWER);
                number.setInput(number.getInput() - (5 * multiple() * 100000));
            }
        }
        if (!four().isEmpty()) {
            while (number.getInput() - (4 * multiple() * 100000) >= 0) {
                number.append(VINCULAR_POWER);
                number.append(four().charAt(0));
                number.append(OVERLINE);
                number.append(four().charAt(1));
                number.append(OVERLINE);
                number.append(VINCULAR_POWER);
                number.setInput(number.getInput() - (4 * multiple() * 100000));
            }
        }
        while (number.getInput() - (1 * multiple() * 100000) >= 0) {
            number.append(VINCULAR_POWER);
            number.append(one());
            number.append(OVERLINE);
            number.append(VINCULAR_POWER);
            number.setInput(number.getInput() - (1 * multiple() * 100000));
        }
    }

    /**
     * This method compares input number to value of grammar (based on the subclass/expression) multiplied by 1000
     * and reduces the value for each iteration and adds a vincular to the output value.
     *
     * @param number
     */
    public void vinculize(Context number) {
        while (number.getInput() - (9 * multiple() * 1000) >= 0) {
            number.append(nine().charAt(0));
            number.append(OVERLINE);
            number.append(nine().charAt(1));
            number.append(OVERLINE);
            number.setInput(number.getInput() - (9 * multiple() * 1000));
        }
        while (number.getInput() - (5 * multiple() * 1000) >= 0) {
            number.append(five());
            number.append(OVERLINE);
            number.setInput(number.getInput() - (5 * multiple() * 1000));
        }
        while (number.getInput() - (4 * multiple() * 1000) >= 0) {
            number.append(four().charAt(0));
            number.append(OVERLINE);
            number.append(four().charAt(1));
            number.append(OVERLINE);
            number.setInput(number.getInput() - (4 * multiple() * 1000));
        }
        while (number.getInput() - (1 * multiple() * 1000) >= 0) {
            number.append(one());
            number.append(OVERLINE);
            number.setInput(number.getInput() - (1 * multiple() * 1000));
        }

    }

    /**
     * This method compares input number to value of grammar (based on the subclass/expression) multiplied by 100000
     * and reduces the value for each iteration.
     *
     * @param number
     */
    public void interpret(Context number) {
        while (number.getInput() - (9 * multiple()) >= 0) {
            number.append(nine());
            number.setInput(number.getInput() - (9 * multiple()));
        }
        while (number.getInput() - (5 * multiple()) >= 0) {
            number.append(five());
            number.setInput(number.getInput() - (5 * multiple()));
        }
        while (number.getInput() - (4 * multiple()) >= 0) {
            number.append(four());
            number.setInput(number.getInput() - (4 * multiple()));
        }
        while (number.getInput() - (1 * multiple()) >= 0) {
            number.append(one());
            number.setInput(number.getInput() - (1 * multiple()));
        }
    }
}
