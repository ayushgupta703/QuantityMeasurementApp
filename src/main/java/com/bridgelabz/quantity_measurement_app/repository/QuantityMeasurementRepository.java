package com.bridgelabz.quantity_measurement_app.repository;

import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Long> {

    // Find operations by operation type (ADD, COMPARE, etc.)
    // List<QuantityMeasurementEntity> findByOperation(String operation);

    // Find operations by measurement type (LengthUnit, WeightUnit etc.)
    // List<QuantityMeasurementEntity> findByThisMeasurementType(String measurementType);

    // Find operations by User Email
    List<QuantityMeasurementEntity> findByUserEmail(String email);

    List<QuantityMeasurementEntity> findByUserEmailAndOperation(String email, String operation);

    List<QuantityMeasurementEntity> findByUserEmailAndThisMeasurementType(String email, String measurementType);

    // Count operations by type
    long countByOperation(String operation);

}