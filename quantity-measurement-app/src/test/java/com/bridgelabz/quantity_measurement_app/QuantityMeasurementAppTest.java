package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.quantity_measurement_app.QuantityMeasurementApp.Feet;
import com.bridgelabz.quantity_measurement_app.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    // ========================
    // Feet Test Cases
    // ========================

    @Test
    void testFeetEquality_SameValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);
        assertTrue(first.equals(second));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(2.0);
        assertFalse(first.equals(second));
    }

    @Test
    void testFeetEquality_NullComparison() {
        Feet first = new Feet(1.0);
        assertFalse(first.equals(null));
    }

    @Test
    void testFeetEquality_DifferentClass() {
        Feet first = new Feet(1.0);
        assertFalse(first.equals("1.0"));
    }

    @Test
    void testFeetEquality_SameReference() {
        Feet first = new Feet(1.0);
        assertTrue(first.equals(first));
    }

    // ========================
    // Inches Test Cases
    // ========================

    @Test
    void testInchesEquality_SameValue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(1.0);
        assertTrue(first.equals(second));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(2.0);
        assertFalse(first.equals(second));
    }

    @Test
    void testInchesEquality_NullComparison() {
        Inches first = new Inches(1.0);
        assertFalse(first.equals(null));
    }

    @Test
    void testInchesEquality_DifferentClass() {
        Inches first = new Inches(1.0);
        assertFalse(first.equals(1.0));
    }

    @Test
    void testInchesEquality_SameReference() {
        Inches first = new Inches(1.0);
        assertTrue(first.equals(first));
    }
}