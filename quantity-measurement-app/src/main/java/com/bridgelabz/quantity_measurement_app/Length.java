package com.bridgelabz.quantity_measurement_app;

import java.util.Objects;

/**
 * A generic class for representing and comparing lengths in different units.
 * Base unit for conversion is INCHES.
 */
public class Length {

    private final double value;
    private final LengthUnit unit;

    /**
     * Enum representing supported length units.
     * Conversion factors are defined relative to inches (base unit).
     */
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    /**
     * Converts this length to base unit (inches).
     */
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    /**
     * Static conversion API (UC5 requirement)
     */
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        double valueInBase = value * source.getConversionFactor();
        return valueInBase / target.getConversionFactor();
    }

    /**
     * Instance conversion method
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    private boolean compare(Length other) {
        return Double.compare(this.convertToBaseUnit(),
                              other.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Length other = (Length) o;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}