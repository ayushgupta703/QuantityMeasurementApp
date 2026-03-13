package com.bridgelabz.quantity_measurement_app.model;

public enum WeightUnit implements Measurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactorToKg;

    WeightUnit(double conversionFactorToKg) {
        this.conversionFactorToKg = conversionFactorToKg;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToKg;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToKg;
    }
}