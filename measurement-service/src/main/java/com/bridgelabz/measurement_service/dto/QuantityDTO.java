// one quantity value
package com.bridgelabz.measurement_service.dto;

import lombok.Data;

@Data
public class QuantityDTO {

    private Double value;
    private String unit;
    private String measurementType;

    public QuantityDTO() {}
}