package com.aem.exercise.romannumeral.service;


import com.aem.exercise.romannumeral.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Service layer class that provides utility to convert decimal value to a roman numeral value.
 * This class defines a grammar list that hold the necessary object that does the conversion.
 */
@Service
public class RomanNumeralService {

    private Logger LOGGER = LoggerFactory.getLogger(RomanNumeralService.class);

    private List<Expression> romanExpressionGrammar;

    public RomanNumeralService() {
        romanExpressionGrammar = new ArrayList<>();
        romanExpressionGrammar.add(new ThousandExpression());
        romanExpressionGrammar.add(new HundredExpression());
        romanExpressionGrammar.add(new TenExpression());
        romanExpressionGrammar.add(new OneExpression());
    }

    /**
     * Method that converts a decimal value to roman number.
     * Expected value are roman numeral or roman numeral - with/without vincular
     * or roman numeral - with/without vincular brackets
     *
     * @param inputNumber - number to be converted to roman numeral
     * @return - a string representing roman numeral
     */
    public String convertToRoman(long inputNumber) {
        LOGGER.debug("In service method - converting decimal value");
        Context inputContext = new Context();
        inputContext.setInput(inputNumber);

        /* Iterate thru the grammar list for each type of operation(vincular with brackets, vincular, normal roman conversion)
         * This converts the input value to a vincular representation with brackets i.e ||
         * then converts the result value to a vincular representation which then feeds the result
         * to normal roman numeral conversion.
         *
         * This uses interpreter pattern where the input and output values are held in an object (here context)
         * and the values are updated for each pass.
         * */
        if (inputNumber > 3999) {
            // Run the vincular operation only if number is greater than 3999.
            // This check is added to avoid showing numbers less than 399 with vincular
            romanExpressionGrammar.stream().forEach(expression -> expression.superVinculize(inputContext));
            romanExpressionGrammar.stream().forEach(expression -> expression.vinculize(inputContext));
        }
        romanExpressionGrammar.stream().forEach(expression -> expression.interpret(inputContext));
        //replace double delimiter value with empty string - this is possible after supervincular(vincular with bracket)
        return inputContext.getOutputValue().replaceAll("\\|\\|","");
    }

}
