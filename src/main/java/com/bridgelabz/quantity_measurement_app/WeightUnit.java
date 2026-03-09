package com.bridgelabz.quantity_measurement_app;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactorToKg;

    WeightUnit(double conversionFactorToKg) {
        this.conversionFactorToKg = conversionFactorToKg;
    }

    public double getConversionFactor() {
        return conversionFactorToKg;
    }

    // convert value → base unit (kg)
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToKg;
    }

    // convert base unit → this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToKg;
    }
}