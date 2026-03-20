package com.bridgelabz.quantity_measurement_app.controller;

import com.bridgelabz.quantity_measurement_app.dto.QuantityInputDTO;
import com.bridgelabz.quantity_measurement_app.dto.QuantityMeasurementDTO;
import com.bridgelabz.quantity_measurement_app.service.IQuantityMeasurementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    /**
     * Compare two quantities
     */
    @PostMapping("/compare")
    public QuantityMeasurementDTO compareQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.compareQuantities(input);
    }

    /**
     * Convert quantity
     */
    @PostMapping("/convert")
    public QuantityMeasurementDTO convertQuantity(
            @RequestBody QuantityInputDTO input) {

        return service.convertQuantity(input);
    }

    /**
     * Add quantities
     */
    @PostMapping("/add")
    public QuantityMeasurementDTO addQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.addQuantities(input);
    }

    /**
     * Subtract quantities
     */
    @PostMapping("/subtract")
    public QuantityMeasurementDTO subtractQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.subtractQuantities(input);
    }

    /**
     * Divide quantities
     */
    @PostMapping("/divide")
    public double divideQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.divideQuantities(input);
    }

    /**
     * Get history by operation
     */
    @GetMapping("/history/operation/{operation}")
    public List<QuantityMeasurementDTO> getHistoryByOperation(
            @PathVariable String operation) {

        return service.getHistoryByOperation(operation);
    }

    /**
     * Get history by measurement type
     */
    @GetMapping("/history/type/{type}")
    public List<QuantityMeasurementDTO> getHistoryByMeasurementType(
            @PathVariable String type) {

        return service.getHistoryByMeasurementType(type);
    }

    /**
     * Count operations
     */
    @GetMapping("/count/{operation}")
    public long getOperationCount(
            @PathVariable String operation) {

        return service.getOperationCount(operation);
    }
}