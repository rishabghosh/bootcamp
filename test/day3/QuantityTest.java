package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldCompareTenFeetToOneHundredAndTwentyInch() {
        Quantity tenFeet = new Quantity(10.0, Unit.FEET);
        Quantity oneTwentyInch = new Quantity(120.0, Unit.INCH);
        assertEquals(tenFeet, oneTwentyInch);
    }

    @Test
    void shouldCompareTenFeetToOneHundredAndThirtyInch() {
        Quantity tenFeet = new Quantity(10.0, Unit.FEET);
        Quantity oneThirtyInch = new Quantity(130.0, Unit.INCH);
        assertNotEquals(tenFeet, oneThirtyInch);
    }

    @Test
    void shouldReturnTrueIfCentiMeterAndMilimeterAreEquivalent() {
        Quantity quantity1 = new Quantity(10.0, Unit.CM);
        Quantity quantity2 = new Quantity(100.0, Unit.MM);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnFalseIfCentiMeterAndMilimeterAreNotEquivalent() {
        Quantity quantity1 = new Quantity(10.0, Unit.CM);
        Quantity quantity2 = new Quantity(99.0, Unit.MM);
        assertNotEquals(quantity1, quantity2);
    }

    @Test
    void shouldCompareOneGallonAndThreePointSevenEightLitreEqual() {
        Quantity oneGallon = new Quantity(1, Unit.GALLON);
        Quantity threePointSevenEightLitre = new Quantity(3.78, Unit.LITRE);
        assertEquals(oneGallon, threePointSevenEightLitre);
    }

    @Test
    void shouldAddTwoAndTwoInches() {
        Quantity twoInch = new Quantity(2, Unit.INCH);
        Quantity expected = new Quantity(4, Unit.INCH);
        assertEquals(expected, twoInch.add(twoInch));
    }
}