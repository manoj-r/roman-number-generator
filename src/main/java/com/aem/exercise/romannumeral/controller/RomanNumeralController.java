package com.aem.exercise.romannumeral.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "romanumeral")
public class RomanNumeralController {

    /**
     *
     * A rest controller method exposing a functionality to
     * convert an integer to roman numeral.
     *
     * This method is exposed using HTTP 'GET' and can be accessed by calling
     * http://{host:port}/romannumeral?query={input}
     *
     * @param input - input value to be converted to roman numeral
     * @return a roman numeral for given input
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getRomanNumeral(@RequestParam("query") String input) {
        int inputValue = Integer.parseUnsignedInt(input);
        return "XX";
    }
}
