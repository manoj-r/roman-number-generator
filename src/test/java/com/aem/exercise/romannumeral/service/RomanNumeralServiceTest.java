package com.aem.exercise.romannumeral.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralServiceTest {

    private RomanNumeralService romanNumeralService;

    @Before
    public void setUp(){
        romanNumeralService = new RomanNumeralService();
    }

    @Test
    public void testconvertToRoman_Simple() {
        Assert.assertEquals("CDXXXVI", romanNumeralService.convertToRoman(436l));
    }

    @Test
    public void testconvertToRoman_Simple_OneDigit() {
        Assert.assertEquals("VIII", romanNumeralService.convertToRoman(8l));
    }

    @Test
    public void testconvertToRoman_Wiki() {
        /*
        39 = "Thirty nine" (XXX+IX) = XXXIX.

        246 = "Two hundred and forty six" (CC+XL+VI) = CCXLVI.
        421 = "Four hundred and twenty one" (CD+XX+I) = CDXXI.
        As each power of ten (or "place") has its own notation there is no need for place keeping zeros, so "missing places" are ignored, as in Latin (and English) speech, thus:

        160 = "One hundred and sixty" (C+LX) = CLX
        207 = "Two hundred and seven" (CC+VII) = CCVII
        1066 = "A thousand and sixty six" (M+LX+VI) = MLXVI.[3][4]
        Roman numerals for large numbers are nowadays seen mainly in the form of year numbers (other uses are detailed later in this article), as in these examples:

        1776 (M+DCC+LXX+VI) = MDCCLXXVI (the date written on the book held by the Statue of Liberty).[5]
        1954 (M+CM+L+IV) = MCMLIV (as in the trailer for the movie The Last Time I Saw Paris)[6]
        1990 (M+CM+XC) = MCMXC (used as the title of musical project Enigma's debut album MCMXC a.D., named after the year of its release).
        2014 (MM+X+IV) = MMXIV (the year of the games of the XXII (22nd) Olympic Winter Games (in Sochi)
        The current year (2019) is MMXIX.
        *
        */

        Assert.assertEquals("XXXIX", romanNumeralService.convertToRoman(39));
        Assert.assertEquals("CCXLVI", romanNumeralService.convertToRoman(246));
        Assert.assertEquals("CDXXI", romanNumeralService.convertToRoman(421));
        Assert.assertEquals("CLX", romanNumeralService.convertToRoman(160));
        Assert.assertEquals("CCVII", romanNumeralService.convertToRoman(207));
        Assert.assertEquals("MLXVI", romanNumeralService.convertToRoman(1066));
        Assert.assertEquals("MDCCLXXVI", romanNumeralService.convertToRoman(1776));
        Assert.assertEquals("MCMLIV", romanNumeralService.convertToRoman(1954));
        Assert.assertEquals("MCMXC", romanNumeralService.convertToRoman(1990));
        Assert.assertEquals("MMXIV", romanNumeralService.convertToRoman(2014));
        Assert.assertEquals("MMXIX", romanNumeralService.convertToRoman(2019));
    }

    @Test
    public void testconvertToRoman_Vinculum_Wiki(){
        /*
        IV = 4,000
        IVDCXXVII = 4,627
        XXV = 25,000
        XXVCDLIX = 25,459
         */
        Assert.assertEquals("I\u0305V\u0305", romanNumeralService.convertToRoman(4000));
        Assert.assertEquals("I\u0305V\u0305DCXXVII", romanNumeralService.convertToRoman(4627));
        Assert.assertEquals("X\u0305X\u0305V\u0305", romanNumeralService.convertToRoman(25000));
        Assert.assertEquals("X\u0305X\u0305V\u0305CDLIX", romanNumeralService.convertToRoman(25459));


    }

    @Test
    public void testconvertToRoman_SuperVinculum_Wiki(){
        /*
        VIII for 80,000 (or 800,000)
        XX for 200,000 (or 2,000,000)
         */
        Assert.assertEquals("|V\u0305I\u0305I\u0305I\u0305|", romanNumeralService.convertToRoman(800000));
        Assert.assertEquals("|X\u0305X\u0305|", romanNumeralService.convertToRoman(2000000));
    }

    @Test
    public void testconvertToRoman() {
        Assert.assertEquals("I\u0305X\u0305CDLVI", romanNumeralService.convertToRoman(9456));
    }

}
