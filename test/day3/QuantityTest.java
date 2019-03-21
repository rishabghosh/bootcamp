package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldCompareTenFeetToOneHundredAndTwentyInchAreEqual() {
        Quantity tenFeet = new Quantity(10.0, Unit.FEET);
        Quantity oneTwentyInch = new Quantity(120.0, Unit.INCH);
        assertEquals(tenFeet, oneTwentyInch);
    }

    @Test
    void shouldCompareTenFeetToOneHundredAndThirtyInchAreNotEqual() {
        Quantity tenFeet = new Quantity(10.0, Unit.FEET);
        Quantity oneThirtyInch = new Quantity(130.0, Unit.INCH);
        assertNotEquals(tenFeet, oneThirtyInch);
    }

    @Test
    void shouldCompareTenCentiMeterAndOneHundredMilliMeterAreEqual() {
        Quantity tenCentiMeter = new Quantity(10.0, Unit.CM);
        Quantity hundredMilliMeter = new Quantity(100.0, Unit.MM);
        assertEquals(tenCentiMeter, hundredMilliMeter);
    }

    @Test
    void shouldReturnFalseIfCentiMeterAndMilliMeterAreNotEqual() {
        Quantity tenCentiMeter = new Quantity(10.0, Unit.CM);
        Quantity ninetyNineMilliMeter = new Quantity(99.0, Unit.MM);
        assertNotEquals(tenCentiMeter, ninetyNineMilliMeter);
    }

    @Test
    void shouldCompareOneGallonAndThreePointSevenEightLitreAreEqual() {
        Quantity oneGallon = new Quantity(1, Unit.GALLON);
        Quantity threePointSevenEightLitre = new Quantity(3.78, Unit.LITRE);
        assertEquals(oneGallon, threePointSevenEightLitre);
    }

    @Test
    void shouldAddTwoAndTwoInches() {
        Quantity twoInch = new Quantity(2, Unit.INCH);
        Quantity fourInch = new Quantity(4, Unit.INCH);
        assertEquals(fourInch, twoInch.add(twoInch));
    }
}