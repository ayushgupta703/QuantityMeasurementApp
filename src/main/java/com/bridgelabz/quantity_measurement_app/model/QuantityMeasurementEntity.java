package com.bridgelabz.quantity_measurement_app.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.bridgelabz.quantity_measurement_app.user.User;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Timestamp
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }
}