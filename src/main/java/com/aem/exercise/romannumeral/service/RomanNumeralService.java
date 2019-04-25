package com.aem.exercise.romannumeral.service;


import com.aem.exercise.romannumeral.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RomanNumeralService {

    private List<Expression> romanExpressionGrammar;

    public RomanNumeralService() {
        romanExpressionGrammar = new ArrayList<>();
        romanExpressionGrammar.add(new ThousandExpression());
        romanExpressionGrammar.add(new HundredExpression());
        romanExpressionGrammar.add(new TenExpression());
        romanExpressionGrammar.add(new OneExpression());
    }

    /**
     *
     * @param inputNumber - number to be converted to roman numeral
     * @return - a string representing roman numeral
     */
    public String convertToRoman(long inputNumber) {
        Context inputContext = new Context();
        inputContext.setInput(inputNumber);

        romanExpressionGrammar.stream().forEach(expression -> expression.superVinculize(inputContext));
        romanExpressionGrammar.stream().forEach(expression -> expression.vinculize(inputContext));
        romanExpressionGrammar.stream().forEach(expression -> expression.interpret(inputContext));

        return inputContext.getOutputValue().replaceAll("\\|\\|","");
    }

}
