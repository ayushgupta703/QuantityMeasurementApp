package com.bridgelabz.measurement_service.service;

import com.bridgelabz.measurement_service.dto.*;
import com.bridgelabz.measurement_service.model.*;
import com.bridgelabz.measurement_service.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"unchecked", "rawtypes"})
@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    /**
     * Convert DTO → Quantity<T>
     */
    private <T extends Measurable> Quantity<T> createQuantity(QuantityDTO dto) {

        switch (dto.getMeasurementType()) {

            case "LengthUnit":
                return (Quantity<T>) new Quantity<>(dto.getValue(), LengthUnit.valueOf(dto.getUnit()));

            case "WeightUnit":
                return (Quantity<T>) new Quantity<>(dto.getValue(), WeightUnit.valueOf(dto.getUnit()));

            case "VolumeUnit":
                return (Quantity<T>) new Quantity<>(dto.getValue(), VolumeUnit.valueOf(dto.getUnit()));

            case "TemperatureUnit":
                return (Quantity<T>) new Quantity<>(dto.getValue(), TemperatureUnit.valueOf(dto.getUnit()));

            default:
                throw new RuntimeException("Invalid measurement type");
        }
    }

    /**
     * Convert Entity → DTO
     */
    private QuantityMeasurementDTO buildDTO(QuantityMeasurementEntity entity) {

        QuantityMeasurementDTO dto = new QuantityMeasurementDTO();

        dto.setThisValue(entity.getThisValue());
        dto.setThisUnit(entity.getThisUnit());
        dto.setThisMeasurementType(entity.getThisMeasurementType());

        dto.setThatValue(entity.getThatValue());
        dto.setThatUnit(entity.getThatUnit());
        dto.setThatMeasurementType(entity.getThatMeasurementType());

        dto.setOperation(entity.getOperation());

        dto.setResultValue(entity.getResultValue());
        dto.setResultUnit(entity.getResultUnit());
        dto.setResultMeasurementType(entity.getResultMeasurementType());

        dto.setResultString(entity.getResultString());

        dto.setError(entity.getError());
        dto.setErrorMessage(entity.getErrorMessage());

        return dto;
    }

    /**
     * Extract user email from JWT
     */
    private String getLoggedInUserEmailOrNull() {
        try {
            String email = SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName();

            if (email == null || email.equals("anonymousUser")) {
                return null;
            }

            return email;
        } catch (Exception e) {
            return null;
        }
    }

    private void saveIfAuthenticated(QuantityMeasurementEntity entity) {
        String email = getLoggedInUserEmailOrNull();

        if (email != null) {
            entity.setUserEmail(email);
            repository.save(entity);
        }
    }

    @Override
    public QuantityMeasurementDTO compareQuantities(QuantityInputDTO input) {

        Quantity q1 = createQuantity(input.getThisQuantityDTO());
        Quantity q2 = createQuantity(input.getThatQuantityDTO());

        boolean result = q1.equals(q2);

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(input.getThisQuantityDTO().getValue());
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThisMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setThatValue(input.getThatQuantityDTO().getValue());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());
        entity.setThatMeasurementType(input.getThatQuantityDTO().getMeasurementType());

        entity.setOperation("COMPARE");
        entity.setResultString(String.valueOf(result));
        entity.setError(false);

        saveIfAuthenticated(entity);

        return buildDTO(entity);
    }

    @Override
    public QuantityMeasurementDTO convertQuantity(QuantityInputDTO input) {

        Quantity q1 = createQuantity(input.getThisQuantityDTO());
        Quantity result;

        switch (input.getThatQuantityDTO().getMeasurementType()) {

            case "LengthUnit":
                result = q1.convertTo(LengthUnit.valueOf(input.getThatQuantityDTO().getUnit()));
                break;

            case "WeightUnit":
                result = q1.convertTo(WeightUnit.valueOf(input.getThatQuantityDTO().getUnit()));
                break;

            case "VolumeUnit":
                result = q1.convertTo(VolumeUnit.valueOf(input.getThatQuantityDTO().getUnit()));
                break;

            case "TemperatureUnit":
                result = q1.convertTo(TemperatureUnit.valueOf(input.getThatQuantityDTO().getUnit()));
                break;

            default:
                throw new RuntimeException("Invalid measurement type");
        }

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(input.getThisQuantityDTO().getValue());
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThisMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setThatValue(input.getThatQuantityDTO().getValue());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());
        entity.setThatMeasurementType(input.getThatQuantityDTO().getMeasurementType());

        entity.setOperation("CONVERT");

        entity.setResultValue(result.getValue());
        entity.setResultUnit(result.getUnit().toString());
        entity.setResultMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setError(false);

        saveIfAuthenticated(entity);

        return buildDTO(entity);
    }

    @Override
    public QuantityMeasurementDTO addQuantities(QuantityInputDTO input) {

        Quantity q1 = createQuantity(input.getThisQuantityDTO());
        Quantity q2 = createQuantity(input.getThatQuantityDTO());

        Quantity result = q1.add(q2);

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(input.getThisQuantityDTO().getValue());
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThisMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setThatValue(input.getThatQuantityDTO().getValue());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());
        entity.setThatMeasurementType(input.getThatQuantityDTO().getMeasurementType());

        entity.setOperation("ADD");

        entity.setResultValue(result.getValue());
        entity.setResultUnit(result.getUnit().toString());
        entity.setResultMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setError(false);

        saveIfAuthenticated(entity);

        return buildDTO(entity);
    }

    @Override
    public QuantityMeasurementDTO subtractQuantities(QuantityInputDTO input) {

        Quantity q1 = createQuantity(input.getThisQuantityDTO());
        Quantity q2 = createQuantity(input.getThatQuantityDTO());

        Quantity result = q1.subtract(q2);

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(input.getThisQuantityDTO().getValue());
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThisMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setThatValue(input.getThatQuantityDTO().getValue());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());
        entity.setThatMeasurementType(input.getThatQuantityDTO().getMeasurementType());

        entity.setOperation("SUBTRACT");

        entity.setResultValue(result.getValue());
        entity.setResultUnit(result.getUnit().toString());
        entity.setResultMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setError(false);

        saveIfAuthenticated(entity);

        return buildDTO(entity);
    }

    @Override
    public QuantityMeasurementDTO divideQuantities(QuantityInputDTO input) {

        Quantity q1 = createQuantity(input.getThisQuantityDTO());
        Quantity q2 = createQuantity(input.getThatQuantityDTO());

        double result = q1.divide(q2);

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(input.getThisQuantityDTO().getValue());
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThisMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setThatValue(input.getThatQuantityDTO().getValue());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());
        entity.setThatMeasurementType(input.getThatQuantityDTO().getMeasurementType());

        entity.setOperation("DIVIDE");

        entity.setResultValue(result);
        entity.setResultUnit(input.getThisQuantityDTO().getUnit());
        entity.setResultMeasurementType(input.getThisQuantityDTO().getMeasurementType());

        entity.setError(false);

        saveIfAuthenticated(entity);

        return buildDTO(entity);
    }

    @Override
    public List<QuantityMeasurementDTO> getAllHistory() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return repository.findByUserEmail(email)
                .stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuantityMeasurementDTO> getHistoryByOperation(String operation) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return repository.findByUserEmailAndOperation(email, operation)
                .stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuantityMeasurementDTO> getHistoryByMeasurementType(String measurementType) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return repository.findByUserEmailAndThisMeasurementType(email, measurementType)
                .stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long getOperationCount(String operation) {
        return repository.countByOperation(operation);
    }
}