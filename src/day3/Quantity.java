package day3;

import java.math.BigDecimal;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(double value, Unit unit) {
        this.value = BigDecimal.valueOf(value);
        this.unit = unit;
    }

    @Override
    public boolean equals(Object otherQuantity) {
        if (this == otherQuantity) return true;
        if (this.getClass() != otherQuantity.getClass()) return false;

        Quantity quantity = (Quantity) otherQuantity;
        if (this.unit.isNotSameType(quantity.unit)) return false;

        BigDecimal valueOfMainQuantity = this.unit.convertToBaseUnit(this.value);
        BigDecimal valueOfGivenQuantity = quantity.unit.convertToBaseUnit(quantity.value);

        int comparedValue = valueOfMainQuantity.compareTo(valueOfGivenQuantity);
        return comparedValue == 0;
    }

    Quantity add(Quantity quantity) throws InvalidUnitTypeException {
        if (this.unit.isNotSameType(quantity.unit)) throw new InvalidUnitTypeException();
        System.out.println("still working");
        BigDecimal quantityInStandardUnit = quantity.unit.convertToStandardUnit(quantity.value);
        BigDecimal currentQuantityInStandardUnit = this.unit.convertToStandardUnit(this.value);
        BigDecimal addedValue = quantityInStandardUnit.add(currentQuantityInStandardUnit);
        Unit standardUnit = this.unit.getStandardUnit();
        return new Quantity(addedValue.doubleValue(), standardUnit);
    }
}
