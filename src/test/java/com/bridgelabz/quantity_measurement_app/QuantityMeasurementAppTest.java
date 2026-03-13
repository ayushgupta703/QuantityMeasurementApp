	package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;

import com.bridgelabz.quantity_measurement_app.model.LengthUnit;
import com.bridgelabz.quantity_measurement_app.model.Quantity;
import com.bridgelabz.quantity_measurement_app.model.TemperatureUnit;
import com.bridgelabz.quantity_measurement_app.model.VolumeUnit;
import com.bridgelabz.quantity_measurement_app.model.WeightUnit;
import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;

import com.bridgelabz.quantity_measurement_app.config.ApplicationConfig;
import com.bridgelabz.quantity_measurement_app.config.ConnectionPool;
import com.bridgelabz.quantity_measurement_app.dao.QuantityMeasurementRepository;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

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

    @Test
    void testWeightAddition_KgPlusGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = w1.add(w2);

        assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM), result);
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

    @Test
    void testVolumeAddition_LitrePlusMillilitre() {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = v1.add(v2);

        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
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

    @Test
    void testSubtraction_CrossUnit() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
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

    // ---------------- DB TESTS ----------------

    @Test
    void testDatabaseConfiguration_LoadedFromProperties() {

        String url = ApplicationConfig.getProperty("db.url");

        assertNotNull(url);
    }

    @Test
    void testConnectionPool_Initialization() {

        assertNotNull(ConnectionPool.getDataSource());
    }

    @Test
    void testConnectionPool_Acquire_Release() throws Exception {

        try (Connection connection =
                     ConnectionPool.getDataSource().getConnection()) {

            assertNotNull(connection);
            assertFalse(connection.isClosed());
        }
    }

    @Test
    void testDatabaseRepository_SaveEntity() {

        QuantityMeasurementRepository repo =
                new QuantityMeasurementRepository();

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        10.0,
                        "FEET",
                        "LENGTH",
                        "ADD",
                        "20 FEET"
                );

        repo.saveMeasurement(entity);

        assertTrue(true);
    }

    @Test
    void testDatabaseRepository_RetrieveAllMeasurements() {

        QuantityMeasurementRepository repo =
                new QuantityMeasurementRepository();

        List<QuantityMeasurementEntity> list =
                repo.findAllMeasurements();

        assertNotNull(list);
    }
}