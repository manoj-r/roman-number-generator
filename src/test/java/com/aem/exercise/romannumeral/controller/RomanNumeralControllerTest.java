package com.aem.exercise.romannumeral.controller;

import com.aem.exercise.romannumeral.service.RomanNumeralService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

public class RomanNumeralControllerTest {

    @Mock
    private RomanNumeralController romanNumeralController;

    @Mock
    private RomanNumeralService romanNumeralService;

    @Before
    public void setUp() {
        this.romanNumeralController = new RomanNumeralController(romanNumeralService);
    }

    @Test
    public void testGetRomanNumeral() {
        String input = "3453";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
    }
}
