package day3;

import java.math.BigDecimal;

class Unit {
    private final BigDecimal ratio;
    private final Object type;

    private static final Object LENGTH = new Object();
    private static final Object VOLUME = new Object();

    static final Unit MM = new Unit(1, LENGTH);
    static final Unit INCH = new Unit(25, LENGTH);
    static final Unit FEET = new Unit(300, LENGTH);
    static final Unit CM = new Unit(10, LENGTH);

    static final Unit GALLON = new Unit(3780, VOLUME);
    static final Unit LITRE = new Unit(1000, VOLUME);

    private Unit(double ratio, Object type) {
        this.type = type;
        this.ratio = BigDecimal.valueOf(ratio);
    }

    BigDecimal convertToBaseUnit(BigDecimal value) {
        return value.multiply(this.ratio);
    }

    boolean isSameType(Unit unit) {
        return this.type.equals(unit.type);
    }
}
