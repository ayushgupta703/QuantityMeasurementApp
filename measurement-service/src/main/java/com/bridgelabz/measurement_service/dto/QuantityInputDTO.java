// Request body for operations
package com.bridgelabz.measurement_service.dto;

import lombok.Data;

@Data
public class QuantityInputDTO {

    private QuantityDTO thisQuantityDTO;
    private QuantityDTO thatQuantityDTO;

    public QuantityInputDTO() {}
}