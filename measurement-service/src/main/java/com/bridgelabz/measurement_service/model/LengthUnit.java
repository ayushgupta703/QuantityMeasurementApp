package com.bridgelabz.measurement_service.model;

public enum LengthUnit implements Measurable {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToFeet;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToFeet;
    }
}