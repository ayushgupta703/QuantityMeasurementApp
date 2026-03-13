package com.bridgelabz.quantity_measurement_app.presentation;

import com.bridgelabz.quantity_measurement_app.dao.IQuantityMeasurementRepository;
import com.bridgelabz.quantity_measurement_app.dao.QuantityMeasurementCacheRepository;
import com.bridgelabz.quantity_measurement_app.service.IQuantityMeasurementService;
import com.bridgelabz.quantity_measurement_app.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repository =
                QuantityMeasurementCacheRepository.getInstance();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.runDemo();
    }
}