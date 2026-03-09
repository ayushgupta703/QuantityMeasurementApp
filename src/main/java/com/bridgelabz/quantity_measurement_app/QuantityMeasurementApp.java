package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length equal? " + l1.equals(l2));

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight equal? " + w1.equals(w2));
    }
}