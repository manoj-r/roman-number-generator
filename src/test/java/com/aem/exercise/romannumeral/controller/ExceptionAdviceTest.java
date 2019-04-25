package com.aem.exercise.romannumeral.controller;

import com.aem.exercise.romannumeral.exception.UnsupportedInputException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class ExceptionAdviceTest {

    private ExceptionAdvice advice = new ExceptionAdvice();

    @Test
    public void testHandleUnSupportedInputException() {
        UnsupportedInputException inputException = new UnsupportedInputException(-5l);
        ResponseEntity<String> adviceResponse = advice.handleUnSupportedInputException(inputException);
        Assert.assertNotNull(adviceResponse);
        Assert.assertEquals("Input value '-5' is not in the range of accepted values {1 - 2200000000}", adviceResponse.getBody());
    }


}
