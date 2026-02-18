package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.quantity_measurement_app.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    void givenSameValue_whenCompared_shouldReturnTrue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        assertTrue(first.equals(second),
                "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    void givenDifferentValue_whenCompared_shouldReturnFalse() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(2.0);

        assertFalse(first.equals(second),
                "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    void givenNull_whenCompared_shouldReturnFalse() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals(null),
                "Feet object should not be equal to null");
    }

    @Test
    void givenDifferentClass_whenCompared_shouldReturnFalse() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals("1.0"),
                "Feet object should not be equal to a different class type");
    }

    @Test
    void givenSameReference_whenCompared_shouldReturnTrue() {
        Feet first = new Feet(1.0);

        assertTrue(first.equals(first),
                "Object should be equal to itself (reflexive property)");
    }
}