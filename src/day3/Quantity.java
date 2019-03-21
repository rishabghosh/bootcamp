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
        if (!this.unit.isSameType(quantity.unit)) return false;
        BigDecimal valueOfMainQuantity = this.unit.convertToBaseUnit(this.value);
        BigDecimal valueOfGivenQuantity = quantity.unit.convertToBaseUnit(quantity.value);
        return valueOfMainQuantity.compareTo(valueOfGivenQuantity) == 0;
    }

    Quantity add(Quantity quantity) {
        BigDecimal addedValue = quantity.value.add(this.value);
        return new Quantity(addedValue.doubleValue(), this.unit);
    }
}
