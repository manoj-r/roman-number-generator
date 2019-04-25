package com.aem.exercise.romannumeral.controller;


import com.aem.exercise.romannumeral.exception.UnsupportedInputException;
import com.aem.exercise.romannumeral.service.RomanNumeralService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "romannumeral")
public class RomanNumeralController {

    private RomanNumeralService romanNumeralService;

    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }

    /**
     * A rest controller exposing a functionality to
     * convert an integer to roman numeral.
     * <p>
     * This method is exposed using HTTP 'GET' and can be accessed by calling
     * http://{host:port}/romannumeral?query={input}
     *
     * @param inputValue - input value to be converted to roman numeral
     * @return a roman numeral for given input
     * @throws UnsupportedInputException if the input value is not in the accepted value rane
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    public ResponseEntity<String> getRomanNumeral(@RequestParam("query") Long inputValue) throws UnsupportedInputException {
        if (inputValue >= 1 && inputValue <= 2200000000l) {
            return ResponseEntity.ok(this.romanNumeralService.convertToRoman(inputValue));
        }
        throw new UnsupportedInputException(inputValue);
    }


}
