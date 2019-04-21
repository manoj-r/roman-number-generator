package com.aem.exercise.romannumeral.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class RomanNumeralControllerTest {

    @Mock
    private RomanNumeralController romanNumeralController;

    @Before
    public void setUp() {
        this.romanNumeralController = new RomanNumeralController();
    }

    @Test
    public void testGetRomanNumeral() {
        String input = "345324";
        String romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
    }
}
