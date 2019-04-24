package com.aem.exercise.romannumeral.controller;

import com.aem.exercise.romannumeral.service.RomanNumeralService;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class RomanNumeralControllerTest {

    private RomanNumeralController romanNumeralController;

    private RomanNumeralService romanNumeralService;

    @Before
    public void setUp() {
        romanNumeralService = Mockito.mock(RomanNumeralService.class);
        this.romanNumeralController = new RomanNumeralController(romanNumeralService);
    }

    //@Test
    public void testGetRomanNumeral() {
        String input = "3453";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
    }
}
