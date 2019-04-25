package com.aem.exercise.romannumeral.service;

import com.aem.exercise.romannumeral.dto.Context;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTest {

    List<Expression> romanExpressionGrammar;
    @Before
    public void setup() {
        romanExpressionGrammar = new ArrayList<>();
        romanExpressionGrammar.add(new ThousandExpression());
        romanExpressionGrammar.add(new HundredExpression());
        romanExpressionGrammar.add(new TenExpression());
        romanExpressionGrammar.add(new OneExpression());

    }

    @Test
    public void testInterpret() {
        Context inputContext = new Context();
        inputContext.setInput(11);
        romanExpressionGrammar.stream().forEach( grammar -> grammar.interpret(inputContext));
        Assert.assertEquals("XI", inputContext.getOutputValue());
    }

    @Test
    public void testVinculize() {
        Context inputContext = new Context();
        inputContext.setInput(11000);
        romanExpressionGrammar.stream().forEach( grammar -> grammar.vinculize(inputContext));
        Assert.assertEquals("X\u0305I\u0305", inputContext.getOutputValue());
    }

    @Test
    public void testSuperVinculize() {
        Context inputContext = new Context();
        inputContext.setInput(100000000);
        romanExpressionGrammar.stream().forEach( grammar -> grammar.superVinculize(inputContext));
        Assert.assertEquals("|M\u0305|", inputContext.getOutputValue());
    }


}
