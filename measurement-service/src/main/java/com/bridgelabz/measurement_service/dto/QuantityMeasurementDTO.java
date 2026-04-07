// API Response
package com.bridgelabz.measurement_service.dto;

import lombok.Data;

@Data
public class QuantityMeasurementDTO {

    private Double thisValue;
    private String thisUnit;
    private String thisMeasurementType;

    private Double thatValue;
    private String thatUnit;
    private String thatMeasurementType;

    private String operation;

    private Double resultValue;
    private String resultUnit;
    private String resultMeasurementType;

    private String resultString;

    private Boolean error;
    private String errorMessage;

    public QuantityMeasurementDTO() {}
}