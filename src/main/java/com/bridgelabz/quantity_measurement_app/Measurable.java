package com.bridgelabz.quantity_measurement_app;

public interface Measurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);
}