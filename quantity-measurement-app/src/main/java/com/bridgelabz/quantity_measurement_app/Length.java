package com.bridgelabz.quantity_measurement_app;

import java.util.Objects;

/**
 * A generic immutable class representing a Length value object.
 * All conversions are normalized to base unit: INCHES.
 */
public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    // ----------------------------
    // ENUM FOR UNITS (UC4)
    // ----------------------------
    public enum LengthUnit {

        INCHES(1.0),
        FEET(12.0),
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

    // ----------------------------
    // CONSTRUCTOR
    // ----------------------------
    public Length(double value, LengthUnit unit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    // ----------------------------
    // GETTERS
    // ----------------------------
    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // ----------------------------
    // BASE CONVERSION (PRIVATE)
    // ----------------------------
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // ----------------------------
    // UC5 – CONVERT TO TARGET UNIT
    // ----------------------------
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = convertToBaseUnit();
        double converted = baseValue / targetUnit.getConversionFactor();

        return new Length(converted, targetUnit);
    }

    // ----------------------------
    // UC6 – ADD (implicit target = this.unit)
    // ----------------------------
    public Length add(Length other) {

        if (other == null)
            throw new IllegalArgumentException("Length to add cannot be null");

        double sumBase = this.convertToBaseUnit() + other.convertToBaseUnit();
        double resultValue = sumBase / this.unit.getConversionFactor();

        return new Length(resultValue, this.unit);
    }

    // ----------------------------
    // UC7 – ADD (explicit target unit)
    // ----------------------------
    public Length add(Length other, LengthUnit targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException("Inputs cannot be null");

        double sumBase = this.convertToBaseUnit() + other.convertToBaseUnit();
        double resultValue = sumBase / targetUnit.getConversionFactor();

        return new Length(resultValue, targetUnit);
    }

    // ----------------------------
    // EQUALITY OVERRIDE (UC3)
    // ----------------------------
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof Length))
            return false;

        Length that = (Length) o;

        return Math.abs(this.convertToBaseUnit()
                - that.convertToBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Math.round(convertToBaseUnit() / EPSILON));
    }

    // ----------------------------
    // STRING REPRESENTATION
    // ----------------------------
    @Override
    public String toString() {
        return String.format("%.4f %s", value, unit);
    }
}