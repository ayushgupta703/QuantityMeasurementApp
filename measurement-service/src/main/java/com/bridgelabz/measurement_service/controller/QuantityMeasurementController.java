package com.bridgelabz.measurement_service.controller;

import com.bridgelabz.measurement_service.dto.QuantityInputDTO;
import com.bridgelabz.measurement_service.dto.QuantityMeasurementDTO;
import com.bridgelabz.measurement_service.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    // Public Operations
    // Compare two quantities
    @PostMapping("/operation/compare")
    public QuantityMeasurementDTO compareQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.compareQuantities(input);
    }

    // Convert quantities
    @PostMapping("/operation/convert")
    public QuantityMeasurementDTO convertQuantity(
            @RequestBody QuantityInputDTO input) {

        return service.convertQuantity(input);
    }

    // Add quantities
    @PostMapping("/operation/add")
    public QuantityMeasurementDTO addQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.addQuantities(input);
    }

    // Subtract quantities
    @PostMapping("/operation/subtract")
    public QuantityMeasurementDTO subtractQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.subtractQuantities(input);
    }

    // Divide quantities
    @PostMapping("/operation/divide")
    public QuantityMeasurementDTO divideQuantities(
            @RequestBody QuantityInputDTO input) {

        return service.divideQuantities(input);
    }

    // Get full history
    @GetMapping("/history")
    public List<QuantityMeasurementDTO> getAllHistory() {
        return service.getAllHistory();
    }

    // Get history by operation
    @GetMapping("/history/operation/{operation}")
    public List<QuantityMeasurementDTO> getHistoryByOperation(
            @PathVariable String operation) {

        return service.getHistoryByOperation(operation);
    }

    // Get history by measurement type
    @GetMapping("/history/type/{type}")
    public List<QuantityMeasurementDTO> getHistoryByMeasurementType(
            @PathVariable String type) {

        return service.getHistoryByMeasurementType(type);
    }

    // Count operations
    @GetMapping("/count/{operation}")
    public long getOperationCount(
            @PathVariable String operation) {

        return service.getOperationCount(operation);
    }
}