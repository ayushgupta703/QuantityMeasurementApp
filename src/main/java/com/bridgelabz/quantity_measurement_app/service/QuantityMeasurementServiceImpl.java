package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.dao.QuantityMeasurementRepository;
import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;

import java.util.List;

public class QuantityMeasurementServiceImpl implements QuantityMeasurementService {

    private final QuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl() {
        this.repository = new QuantityMeasurementRepository();
    }

    @Override
    public void saveMeasurement(QuantityMeasurementEntity entity) {
        repository.saveMeasurement(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return repository.findAllMeasurements();
    }

    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByType(String type) {
        return repository.findByMeasurementType(type);
    }

    @Override
    public void deleteMeasurement(int id) {
        repository.deleteMeasurement(id);
    }
}