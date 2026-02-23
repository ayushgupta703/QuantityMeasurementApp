package com.bridgelabz.quantity_measurement_app;

/**
 * UC5 – Unit-to-Unit Conversion Support
 */
public class QuantityMeasurementApp {

    /**
     * Equality demonstration API
     */
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    /**
     * Conversion API using raw values
     */
    public static double demonstrateLengthConversion(double value, Length.LengthUnit fromUnit, Length.LengthUnit toUnit) {
        return Length.convert(value, fromUnit, toUnit);
    }

    /**
     * Overloaded conversion API using Length object
     */
    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        if (length == null)
            throw new IllegalArgumentException("Length cannot be null");

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {
        System.out.println("1 Foot to Inches: " + demonstrateLengthConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));

        System.out.println("3 Yards to Feet: " + demonstrateLengthConversion(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));
    }
}