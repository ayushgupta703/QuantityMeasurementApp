package com.bridgelabz.quantity_measurement_app.presentation;

import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;
import com.bridgelabz.quantity_measurement_app.service.QuantityMeasurementService;
import com.bridgelabz.quantity_measurement_app.service.QuantityMeasurementServiceImpl;

import java.util.List;

public class QuantityMeasurementController {

    private final QuantityMeasurementService service;

    public QuantityMeasurementController() {
        this.service = new QuantityMeasurementServiceImpl();
    }

    public void saveMeasurement(double value,
                                String unit,
                                String measurementType,
                                String operation,
                                String result) {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        value,
                        unit,
                        measurementType,
                        operation,
                        result
                );

        service.saveMeasurement(entity);

        System.out.println("Measurement saved successfully!");
    }

    public void displayAllMeasurements() {

        List<QuantityMeasurementEntity> measurements =
                service.getAllMeasurements();

        if (measurements.isEmpty()) {
            System.out.println("No measurements found.");
            return;
        }

        for (QuantityMeasurementEntity m : measurements) {
            System.out.println(m);
        }
    }

    public void displayMeasurementsByType(String type) {

        List<QuantityMeasurementEntity> measurements =
                service.getMeasurementsByType(type);

        if (measurements.isEmpty()) {
            System.out.println("No measurements found for type: " + type);
            return;
        }

        for (QuantityMeasurementEntity m : measurements) {
            System.out.println(m);
        }
    }

    public void deleteMeasurement(int id) {

        service.deleteMeasurement(id);

        System.out.println("Measurement deleted successfully!");
    }
}