package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.dto.QuantityInputDTO;
import com.bridgelabz.quantity_measurement_app.dto.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compareQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO convertQuantity(QuantityInputDTO input);

    QuantityMeasurementDTO addQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO subtractQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO divideQuantities(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getHistoryByOperation(String operation);

    List<QuantityMeasurementDTO> getHistoryByMeasurementType(String measurementType);

    long getOperationCount(String operation);

}