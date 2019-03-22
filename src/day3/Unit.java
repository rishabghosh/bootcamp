package day3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

abstract class Unit {
//    private final BigDecimal ratio;
//    public Object type;
//
//    private static final Object LENGTH = new Object();
//    private static final Object VOLUME = new Object();
//
//    static final Unit INCH = new Unit(25, LENGTH);
//    static final Unit MM = new Unit(1, LENGTH);
//    static final Unit FEET = new Unit(300, LENGTH);
//    static final Unit CM = new Unit(10, LENGTH);
//
//    static final Unit GALLON = new Unit(3780, VOLUME);
//    static final Unit LITRE = new Unit(1000, VOLUME);
//
//    private static Map<Object, Unit> standardUnits = new HashMap<>();

//    static {
//        standardUnits.put(LENGTH, Unit.INCH);
//        standardUnits.put(VOLUME, Unit.LITRE);
//    }
//
//    protected Unit(double ratio, Object type) {
//        this.type = type;
//        this.ratio = BigDecimal.valueOf(ratio);
//    }

    abstract BigDecimal convertToBaseUnit(BigDecimal value);

//    abstract boolean isNotSameType(Unit unit);

    abstract Unit getStandardUnit();

//    abstract Unit getUnit();

    abstract BigDecimal convertToStandardUnit(BigDecimal value);
//    {
//        BigDecimal baseUnitValue = this.convertToBaseUnit(value);
//        return  baseUnitValue.divide(getStandardUnit().ratio);
//    }

    abstract boolean isNotSameType(Unit unit);

}
