package day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    @DisplayName("should convert inches to MM")
    void shouldReturnEquivalentValueOfInchesInMiliMeter() {
        BigDecimal actual = Unit.INCH.convertToBaseUnit(BigDecimal.valueOf(1.0));
        BigDecimal expected = BigDecimal.valueOf(25.0);
        assertTrue(expected.compareTo(actual) == 0);
    }

    @Test
    @DisplayName("should convert FEET to MM")
    void shouldReturnEquivalentValueOfFeetInMiliMeter() {
        BigDecimal actual = Unit.FEET.convertToBaseUnit(BigDecimal.valueOf(1.0));
        BigDecimal expected = BigDecimal.valueOf(300.0);
        assertTrue(expected.compareTo(actual) == 0);
    }


}