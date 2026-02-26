package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit to) {
        return length.convertTo(to);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2, LengthUnit target) {
        return l1.add(l2, target);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Equal? " + demonstrateLengthEquality(l1, l2));

        Length converted = demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);

        System.out.println("Converted: " + converted);
    }
}