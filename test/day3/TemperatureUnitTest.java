package day3;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureUnitTest {

    @Test
    void shouldConvertFahrenheitToBaseValue() {
        BigDecimal twoHundredTwelve = BigDecimal.valueOf(212.0);
        BigDecimal inBaseUnit = TemperatureUnit.FAHRENHEIT.convertToBaseUnit(twoHundredTwelve);
        double actual = inBaseUnit.doubleValue();
        assertEquals(100, actual);
    }

    @Test
    void shouldReturnTheSameValueForMinusFortyFahrenheit() {
        BigDecimal twoHundredTwelve = BigDecimal.valueOf(-40.0);
        BigDecimal inBaseUnit = TemperatureUnit.FAHRENHEIT.convertToBaseUnit(twoHundredTwelve);
        double actual = inBaseUnit.doubleValue();
        assertEquals(-40, actual);
    }

    @Test
    void shouldReturnZeroIf32FahrenheitIsGiven() {
        BigDecimal twoHundredTwelve = BigDecimal.valueOf(32.0);
        BigDecimal inBaseUnit = TemperatureUnit.FAHRENHEIT.convertToBaseUnit(twoHundredTwelve);
        double actual = inBaseUnit.doubleValue();
        assertEquals(0, actual);
    }
}