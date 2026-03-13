package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.dao.IQuantityMeasurementRepository;
import com.bridgelabz.quantity_measurement_app.model.Measurable;
import com.bridgelabz.quantity_measurement_app.model.Quantity;
import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends Measurable> boolean compare(Quantity<T> q1, Quantity<T> q2) {

        boolean result = q1.equals(q2);

        repository.save(new QuantityMeasurementEntity("COMPARE", q1, q2, result));

        return result;
    }

    @Override
    public <T extends Measurable> Quantity<T> convert(Quantity<T> quantity, T targetUnit) {

        Quantity<T> result = quantity.convertTo(targetUnit);

        repository.save(new QuantityMeasurementEntity("CONVERT", quantity, null, result));

        return result;
    }

    @Override
    public <T extends Measurable> Quantity<T> add(Quantity<T> q1, Quantity<T> q2) {

        Quantity<T> result = q1.add(q2);

        repository.save(new QuantityMeasurementEntity("ADD", q1, q2, result));

        return result;
    }

    @Override
    public <T extends Measurable> Quantity<T> subtract(Quantity<T> q1, Quantity<T> q2) {

        Quantity<T> result = q1.subtract(q2);

        repository.save(new QuantityMeasurementEntity("SUBTRACT", q1, q2, result));

        return result;
    }

    @Override
    public <T extends Measurable> double divide(Quantity<T> q1, Quantity<T> q2) {

        double result = q1.divide(q2);

        repository.save(new QuantityMeasurementEntity("DIVIDE", q1, q2, result));

        return result;
    }
}