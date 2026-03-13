package com.bridgelabz.quantity_measurement_app.presentation;

import com.bridgelabz.quantity_measurement_app.model.*;
import com.bridgelabz.quantity_measurement_app.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void runDemo() {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Is Length Equal?: " + service.compare(l1, l2));

        System.out.println("Addition: " + service.add(l1, l2));

        System.out.println("Division: " + service.divide(l1, l2));
    }
}