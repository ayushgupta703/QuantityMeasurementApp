package com.bridgelabz.measurement_service.service;

import com.bridgelabz.measurement_service.dto.QuantityInputDTO;
import com.bridgelabz.measurement_service.dto.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compareQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO convertQuantity(QuantityInputDTO input);

    QuantityMeasurementDTO addQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO subtractQuantities(QuantityInputDTO input);

    QuantityMeasurementDTO divideQuantities(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getAllHistory();

    List<QuantityMeasurementDTO> getHistoryByOperation(String operation);

    List<QuantityMeasurementDTO> getHistoryByMeasurementType(String measurementType);

    long getOperationCount(String operation);

}