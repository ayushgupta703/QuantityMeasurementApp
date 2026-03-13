package com.bridgelabz.quantity_measurement_app.service;

import com.bridgelabz.quantity_measurement_app.model.Measurable;
import com.bridgelabz.quantity_measurement_app.model.Quantity;

public interface IQuantityMeasurementService {

    <T extends Measurable> boolean compare(Quantity<T> q1, Quantity<T> q2);

    <T extends Measurable> Quantity<T> convert(Quantity<T> quantity, T targetUnit);

    <T extends Measurable> Quantity<T> add(Quantity<T> q1, Quantity<T> q2);

    <T extends Measurable> Quantity<T> subtract(Quantity<T> q1, Quantity<T> q2);

    <T extends Measurable> double divide(Quantity<T> q1, Quantity<T> q2);
}