package com.bridgelabz.quantity_measurement_app;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    public double getConversionFactor() {
        return conversionFactorToFeet;
    }

    // Convert value in this unit → base unit (FEET)
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToFeet;
    }

    // Convert value from base unit (FEET) → this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToFeet;
    }
}