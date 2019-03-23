package day3;

import java.math.BigDecimal;
import java.math.MathContext;

public class TemperatureUnit extends Unit {

    static final TemperatureUnit CELSIUS = new TemperatureUnit(1, 0);
    static final TemperatureUnit FAHRENHEIT = new TemperatureUnit(1.8, 32);
    private final BigDecimal scale;
    private final BigDecimal ratio;

    private TemperatureUnit(double ratio, double scale) {
        this.ratio = BigDecimal.valueOf(ratio);
        this.scale = BigDecimal.valueOf(scale);
    }


    @Override
    BigDecimal convertToBaseUnit(BigDecimal value) {
        BigDecimal withoutScale = value.subtract(this.scale);
        return withoutScale.divide(this.ratio);
    }

    @Override
    Unit getStandardUnit() {
        return CELSIUS;
    }

    @Override
    BigDecimal convertToStandardUnit(BigDecimal value) {
        BigDecimal withoutScale = value.subtract(this.scale);
        return withoutScale.divide(this.ratio);
    }

    @Override
    boolean isNotSameType(Unit unit) {
        return !(unit instanceof TemperatureUnit);
    }
}
