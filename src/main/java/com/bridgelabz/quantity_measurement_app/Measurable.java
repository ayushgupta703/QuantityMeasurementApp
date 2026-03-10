package com.bridgelabz.quantity_measurement_app;

public interface Measurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);
    
 // default lambda: arithmetic supported
    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
        // default implementation allows operations
    }
}