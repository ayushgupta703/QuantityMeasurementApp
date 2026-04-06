package com.bridgelabz.measurement_service.model;

public interface Measurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    // default arithmetic support
    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
        // default allows arithmetic
    }

    default String getMeasurementType() {
        return this.getClass().getSimpleName();
    }
}