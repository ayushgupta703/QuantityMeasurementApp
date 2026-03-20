package com.bridgelabz.quantity_measurement_app;

import com.bridgelabz.quantity_measurement_app.model.*;
import com.bridgelabz.quantity_measurement_app.repository.QuantityMeasurementRepository;
import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuantityMeasurementApplicationTests {

    @Autowired
    private QuantityMeasurementRepository repository;

    // ---------------- SPRING BOOT TEST ----------------

    @Test
    void testSpringBootApplicationStarts() {
        assertNotNull(repository);
    }

    // ---------------- LENGTH TESTS ----------------

    @Test
    void testLengthEquality_FeetToInches() {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testLengthConversion_YardsToFeet() {

        Quantity<LengthUnit> length =
                new Quantity<>(3.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result =
                length.convertTo(LengthUnit.FEET);

        assertEquals(new Quantity<>(9.0, LengthUnit.FEET), result);
    }

    @Test
    void testLengthAddition() {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    // ---------------- WEIGHT TESTS ----------------

    @Test
    void testWeightEquality_KgToGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    // ---------------- VOLUME TESTS ----------------

    @Test
    void testVolumeEquality_LitreToMillilitre() {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    // ---------------- SUBTRACTION TESTS ----------------

    @Test
    void testSubtraction_SameUnit() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);
    }

    // ---------------- DIVISION TESTS ----------------

    @Test
    void testDivision_SameUnit() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result);
    }

    // ---------------- TEMPERATURE TESTS ----------------

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertTrue(t1.equals(t2));
    }

    @Test
    void testTemperatureUnsupported_Addition() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.add(t2)
        );
    }

    // ---------------- JPA REPOSITORY TESTS ----------------

    @Test
    void testRepository_SaveEntity() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setOperation("ADD");
        entity.setThisValue(1.0);
        entity.setThisUnit("FEET");
        entity.setThisMeasurementType("LengthUnit");

        entity.setThatValue(12.0);
        entity.setThatUnit("INCHES");
        entity.setThatMeasurementType("LengthUnit");

        entity.setResultValue(2.0);
        entity.setResultUnit("FEET");
        entity.setResultMeasurementType("LengthUnit");

        repository.save(entity);

        assertNotNull(entity.getId());
    }

    @Test
    void testRepository_FindByOperation() {

        List<QuantityMeasurementEntity> results =
                repository.findByOperation("ADD");

        assertNotNull(results);
    }

    @Test
    void testRepository_CountByOperation() {

        long count = repository.countByOperation("ADD");

        assertTrue(count >= 0);
    }
}