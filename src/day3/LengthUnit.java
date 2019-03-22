package day3;

import java.math.BigDecimal;

class LengthUnit extends Unit {
    static final LengthUnit INCH = new LengthUnit(25);
    static final LengthUnit MM = new LengthUnit(1);
    static final LengthUnit FEET = new LengthUnit(300);
    static final LengthUnit CM = new LengthUnit(10);
    private final BigDecimal ratio;

    private LengthUnit(double ratio) {
        this.ratio = BigDecimal.valueOf(ratio);
    }

    @Override
    BigDecimal convertToBaseUnit(BigDecimal value) {
        return value.multiply(this.ratio);
    }

    @Override
    Unit getStandardUnit() {
        return INCH;
    }

    @Override
    BigDecimal convertToStandardUnit(BigDecimal value) {
        BigDecimal baseUnitValue = this.convertToBaseUnit(value);
        return baseUnitValue.divide(INCH.ratio);
    }

    @Override
    boolean isNotSameType(Unit unit) {
        return !(unit instanceof LengthUnit);
    }
}
