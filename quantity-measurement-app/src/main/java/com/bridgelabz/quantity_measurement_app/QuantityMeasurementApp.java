package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void main(String[] args) {

        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);

        System.out.println("Are lengths equal? " +
                demonstrateLengthEquality(length1, length2));
    }
}