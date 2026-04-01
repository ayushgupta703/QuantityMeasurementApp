package com.bridgelabz.quantity_measurement_app.model;

import java.util.function.Function;

public enum TemperatureUnit implements Measurable {

    CELSIUS(
            c -> c,
            c -> c
    ),

    FAHRENHEIT(
            f -> (f - 32) * 5 / 9,
            c -> (c * 9 / 5) + 32
    );

    private final Function<Double, Double> toBase;
    private final Function<Double, Double> fromBase;

    TemperatureUnit(Function<Double, Double> toBase,
                    Function<Double, Double> fromBase) {
        this.toBase = toBase;
        this.fromBase = fromBase;
    }

    private final SupportsArithmetic supportsArithmetic = () -> false;

    @Override
    public double convertToBaseUnit(double value) {
        return toBase.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return fromBase.apply(baseValue);
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation + " operation");
    }
}