package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldCompareTenFeetToOneHundredAndTwentyInchAreEqual() {
        Quantity tenFeet = new Quantity(10.0, LengthUnit.FEET);
        Quantity oneTwentyInch = new Quantity(120.0, LengthUnit.INCH);
        assertEquals(tenFeet, oneTwentyInch);
    }

    @Test
    void shouldCompareTenFeetToOneHundredAndThirtyInchAreNotEqual() {
        Quantity tenFeet = new Quantity(10.0, LengthUnit.FEET);
        Quantity oneThirtyInch = new Quantity(130.0, LengthUnit.INCH);
        assertNotEquals(tenFeet, oneThirtyInch);
    }

    @Test
    void shouldCompareTenCentiMeterAndOneHundredMilliMeterAreEqual() {
        Quantity tenCentiMeter = new Quantity(10.0, LengthUnit.CM);
        Quantity hundredMilliMeter = new Quantity(100.0, LengthUnit.MM);
        assertEquals(tenCentiMeter, hundredMilliMeter);
    }

    @Test
    void shouldReturnFalseIfCentiMeterAndMilliMeterAreNotEqual() {
        Quantity tenCentiMeter = new Quantity(10.0, LengthUnit.CM);
        Quantity ninetyNineMilliMeter = new Quantity(99.0, LengthUnit.MM);
        assertNotEquals(tenCentiMeter, ninetyNineMilliMeter);
    }

    @Test
    void shouldCompareOneGallonAndThreePointSevenEightLitreAreEqual() {
        Quantity oneGallon = new Quantity(1, VolumeUnit.GALLON);
        Quantity threePointSevenEightLitre = new Quantity(3.78, VolumeUnit.LITRE);
        assertEquals(oneGallon, threePointSevenEightLitre);
    }

    @Test
    void shouldAddTwoAndTwoInches() throws InvalidUnitTypeException {
        Quantity twoInch = new Quantity(2, LengthUnit.INCH);
        Quantity fourInch = new Quantity(4, LengthUnit.INCH);
        Quantity actual = twoInch.add(twoInch);
        assertEquals(fourInch, actual);
    }

    @Test
    void shouldThrowInvalidUnitTypeExceptionForDissimilarTypeOfUnit() throws InvalidUnitTypeException {
        Quantity twoInch = new Quantity(2, LengthUnit.INCH);
        Quantity fourGallons = new Quantity(4, VolumeUnit.GALLON);
//        System.out.println(twoInch.add(fourGallons));
        assertThrows(InvalidUnitTypeException.class, ()-> twoInch.add(fourGallons));
    }

    @Test
    void shouldReturnThreeInchForTheAdditionOfTwoInchAndTwoAndHalfCentiMeter() throws InvalidUnitTypeException {
        Quantity twoInch = new Quantity(2, LengthUnit.INCH);
        Quantity twoAndHalfCentiMeter = new Quantity(2.5, LengthUnit.CM);
        Quantity expected = new Quantity(3, LengthUnit.INCH);
        Quantity actual = twoInch.add(twoAndHalfCentiMeter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn24InchesForTheAdditionOf1FeetAnd12Inches() throws InvalidUnitTypeException {
        Quantity oneFeet = new Quantity(1, LengthUnit.FEET);
        Quantity twelveInches = new Quantity(12, LengthUnit.INCH);
        Quantity expected = new Quantity(24, LengthUnit.INCH);
        Quantity actual = oneFeet.add(twelveInches);
        assertEquals(expected, actual);
    }
}