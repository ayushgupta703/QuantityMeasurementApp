package com.bridgelabz.quantity_measurement_app.model;

public class QuantityMeasurementEntity {

    private int id;
    private double value;
    private String unit;
    private String measurementType;
    private String operation;
    private String result;

    public QuantityMeasurementEntity() {}

    public QuantityMeasurementEntity(double value, String unit,
                                     String measurementType,
                                     String operation,
                                     String result) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
        this.operation = operation;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        return result;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "QuantityMeasurementEntity{" +
                "id=" + id +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", measurementType='" + measurementType + '\'' +
                ", operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}