package day3;

import java.math.BigDecimal;

class VolumeUnit extends Unit {
    static final VolumeUnit GALLON = new VolumeUnit(3780);
    static final VolumeUnit LITRE = new VolumeUnit(1000);

    private final BigDecimal ratio;

    private VolumeUnit(double ratio) {
        this.ratio = BigDecimal.valueOf(ratio);
    }

    @Override
    BigDecimal convertToBaseUnit(BigDecimal value) {
        return value.multiply(this.ratio);
    }

    @Override
    Unit getStandardUnit() {
        return LITRE;
    }

    @Override
    BigDecimal convertToStandardUnit(BigDecimal value) {
        BigDecimal baseUnitValue = this.convertToBaseUnit(value);
        return baseUnitValue.divide(LITRE.ratio);
    }

    @Override
    boolean isNotSameType(Unit unit) {
        return !(unit instanceof VolumeUnit);
    }
}
