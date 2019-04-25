package com.aem.exercise.romannumeral.controller;

import com.aem.exercise.romannumeral.exception.UnsupportedInputException;
import com.aem.exercise.romannumeral.service.RomanNumeralService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RomanNumeralControllerTest {

    private RomanNumeralController romanNumeralController;

    private RomanNumeralService romanNumeralService;

    @Before
    public void setUp() {
        romanNumeralService = Mockito.mock(RomanNumeralService.class);
        this.romanNumeralController = new RomanNumeralController(romanNumeralService);
    }

    @Test
    public void testGetRomanNumeral() {
        String input = "3453";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
        Assert.assertEquals(HttpStatus.OK,romanNumeral.getStatusCode());
        Mockito.verify(romanNumeralService, Mockito.times(1)).convertToRoman(3453l);
    }

    @Test
    public void testGetRomanNumeral_boundary_low() {
        String input = "1";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
        Assert.assertEquals(HttpStatus.OK,romanNumeral.getStatusCode());
        Mockito.verify(romanNumeralService, Mockito.times(1)).convertToRoman(1l);
    }

    @Test
    public void testGetRomanNumeral_boundary_high() {
        String input = "2200000000";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
        Assert.assertEquals(HttpStatus.OK,romanNumeral.getStatusCode());
        Mockito.verify(romanNumeralService, Mockito.times(1)).convertToRoman(2200000000l);
    }

    @Test(expected = UnsupportedInputException.class)
    public void testGetRomanNumeral_OutOfRange() {
        String input = "2200000001";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
        Assert.assertEquals(HttpStatus.BAD_REQUEST,romanNumeral.getStatusCode());
        Mockito.verify(romanNumeralService, Mockito.times(0)).convertToRoman(Mockito.any());
    }

    @Test(expected = UnsupportedInputException.class)
    public void testGetRomanNumeral_unsupportedFormat() {
        String input = "2200000001";
        ResponseEntity<String> romanNumeral = this.romanNumeralController.getRomanNumeral(input);
        Assert.assertNotNull(romanNumeral);
        Assert.assertEquals(HttpStatus.BAD_REQUEST,romanNumeral.getStatusCode());
        Mockito.verify(romanNumeralService, Mockito.times(0)).convertToRoman(Mockito.any());
    }


}
