package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;

import java.util.List;

public interface QuantityMeasurementService {

    void saveMeasurement(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

    List<QuantityMeasurementEntity> getMeasurementsByType(String type);

    void deleteMeasurement(int id);
}