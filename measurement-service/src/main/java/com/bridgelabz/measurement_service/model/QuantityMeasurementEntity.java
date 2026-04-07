package com.bridgelabz.measurement_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "quantity_measurements")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // First quantity
    private Double thisValue;
    private String thisUnit;
    private String thisMeasurementType;

    // Second quantity
    private Double thatValue;
    private String thatUnit;
    private String thatMeasurementType;

    // Operation performed
    private String operation;

    // Result
    private Double resultValue;
    private String resultUnit;
    private String resultMeasurementType;

    private String resultString;

    // Error handling
    private Boolean error;
    private String errorMessage;

    private String userEmail;

    // Timestamp
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }
}