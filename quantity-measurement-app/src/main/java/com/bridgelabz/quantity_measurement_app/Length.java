package com.bridgelabz.quantity_measurement_app;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Length(round(converted), targetUnit);
    }

    public Length add(Length other) {
        return add(other, this.unit);
    }

    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Length cannot be null");

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;
        double finalValue = targetUnit.convertFromBaseUnit(sumBase);

        return new Length(round(finalValue), targetUnit);
    }

    private boolean compare(Length other) {
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return round(base1) == round(base2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length other = (Length) o;
        return compare(other);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}