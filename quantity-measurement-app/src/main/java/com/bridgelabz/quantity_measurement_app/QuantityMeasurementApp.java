package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {
    // -----------------------
    // Equality
    // -----------------------

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Lengths cannot be null");

        return l1.equals(l2);
    }

    // -----------------------
    // Conversion (UC5)
    // -----------------------

    public static double convert(double value,
                                 Length.LengthUnit source,
                                 Length.LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        return value * (source.getConversionFactor() / target.getConversionFactor());
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit targetUnit) {

        if (length == null || targetUnit == null)
            throw new IllegalArgumentException("Inputs cannot be null");

        return length.convertTo(targetUnit);
    }

    // -----------------------
    // UC6 Addition (implicit target = first operand)
    // -----------------------

    public static Length demonstrateLengthAddition(Length l1, Length l2) {

        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Lengths cannot be null");

        return l1.add(l2);
    }

    // -----------------------
    // UC7 Addition (explicit target unit)
    // -----------------------

    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2,
            Length.LengthUnit targetUnit) {

        if (l1 == null || l2 == null || targetUnit == null)
            throw new IllegalArgumentException("Inputs cannot be null");

        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result1 = demonstrateLengthAddition(l1, l2);
        System.out.println("Implicit Target Result: " + result1);

        Length result2 = demonstrateLengthAddition(
                l1, l2, Length.LengthUnit.YARDS);
        System.out.println("Explicit Target (YARDS): " + result2);
    }
}