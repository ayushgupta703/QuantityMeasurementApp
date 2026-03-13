package com.bridgelabz.quantity_measurement_app.model;

public class QuantityMeasurementEntity {

    private final String operation;
    private final Object operand1;
    private final Object operand2;
    private final Object result;

    public QuantityMeasurementEntity(
            String operation,
            Object operand1,
            Object operand2,
            Object result) {

        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    @Override
    public String toString() {
        return operation + " -> " + operand1 + " , " + operand2 + " = " + result;
    }
}