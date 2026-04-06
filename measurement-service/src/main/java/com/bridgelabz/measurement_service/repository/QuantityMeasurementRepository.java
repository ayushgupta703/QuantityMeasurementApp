package com.bridgelabz.measurement_service.repository;

import com.bridgelabz.measurement_service.model.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Long> {
    // Find operations by User Email
    List<QuantityMeasurementEntity> findByUserEmail(String email);

    List<QuantityMeasurementEntity> findByUserEmailAndOperation(String email, String operation);

    List<QuantityMeasurementEntity> findByUserEmailAndThisMeasurementType(String email, String measurementType);

    // Count operations by type
    long countByOperation(String operation);

}