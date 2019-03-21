package day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    @DisplayName("should convert inches to mm")
    void shouldReturnEquivalentValueOfInchesInMiliMeter() {
        BigDecimal actual = Unit.inch.convertToMM(BigDecimal.valueOf(1.0));
        BigDecimal expected = BigDecimal.valueOf(25.0);
        assertTrue(expected.compareTo(actual) == 0);
    }

    @Test
    @DisplayName("should convert feet to mm")
    void shouldReturnEquivalentValueOfFeetInMiliMeter() {
        BigDecimal actual = Unit.feet.convertToMM(BigDecimal.valueOf(1.0));
        BigDecimal expected = BigDecimal.valueOf(300.0);
        System.out.println(actual);
        assertTrue(expected.compareTo(actual) == 0);
    }


}