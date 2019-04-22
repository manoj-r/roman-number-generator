package com.aem.exercise.romannumeral.service;


import com.aem.exercise.romannumeral.dto.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RomanNumeralService {

    public static String convertIntegertoRoman(int inputNumber) {
        Context inputContext = new Context();
        inputContext.setInput(inputNumber);

        List<Expression> romanExpressionGrammar = new ArrayList<>();
        romanExpressionGrammar.add(new ThousandExpression());
        romanExpressionGrammar.add(new HundredExpression());
        romanExpressionGrammar.add(new TenExpression());
        romanExpressionGrammar.add(new OneExpression());

        romanExpressionGrammar.stream().forEach(expression -> expression.interpret(inputContext));

        return inputContext.getOutputValue();
    }

    public static void main(String[] args) {
        System.out.println("I&#773;");
        System.out.println(new String(convertIntegertoRoman(4000).getBytes(), StandardCharsets.UTF_8));
    }
}
