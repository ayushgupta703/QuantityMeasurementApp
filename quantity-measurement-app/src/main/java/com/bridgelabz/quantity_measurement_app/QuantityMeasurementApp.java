package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {

    /**
     * Demonstrates equality check between two Length objects.
     */
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {

        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Lengths cannot be null");

        return l1.equals(l2);
    }

    /**
     * Demonstrates comparison by creating two Length objects.
     */
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return demonstrateLengthEquality(l1, l2);
    }

    /**
     * UC5 – Conversion method (value-based).
     */
    public static double convert(double value,
                                 Length.LengthUnit source,
                                 Length.LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        return value * (source.getConversionFactor() / target.getConversionFactor());
    }

    /**
     * UC5 – Conversion using Length instance.
     */
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit targetUnit) {

        if (length == null || targetUnit == null)
            throw new IllegalArgumentException("Inputs cannot be null");

        return length.convertTo(targetUnit);
    }

    /**
     * UC6 – Addition of two Length objects.
     * Result is returned in unit of first operand.
     */
    public static Length demonstrateLengthAddition(Length l1, Length l2) {

        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Lengths cannot be null");

        return l1.add(l2);
    }

    /**
     * Main method for quick manual testing.
     */
    public static void main(String[] args) {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length sum = demonstrateLengthAddition(l1, l2);

        System.out.println("Addition Result: " + sum);

        double converted = convert(1.0, Length.LengthUnit.FEET,
                                   Length.LengthUnit.INCHES);

        System.out.println("1 Foot in Inches: " + converted);
    }
}