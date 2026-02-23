package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    // -------------------------
    // UC5 CONVERSION TESTS
    // -------------------------

    @Test
    void testConversion_FeetToInches() {
        double result = QuantityMeasurementApp.convert(
                1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES
        );
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        double result = QuantityMeasurementApp.convert(
                24.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET
        );
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {
        double result = QuantityMeasurementApp.convert(
                1.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES
        );
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        double result = QuantityMeasurementApp.convert(
                2.54,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES
        );
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0, null,
                        Length.LengthUnit.INCHES));
    }

    @Test
    void testConversion_NaN_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));
    }

    // -------------------------
    // UC6 ADDITION TESTS
    // -------------------------

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_InchesPlusFeet() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(l1, l2);

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_Commutativity() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length sum1 = a.add(b).convertTo(Length.LengthUnit.INCHES);
        Length sum2 = b.add(a);

        assertEquals(sum1, sum2);
    }

    @Test
    void testAddition_WithZero() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length zero = new Length(0.0, Length.LengthUnit.FEET);

        assertEquals(l1, l1.add(zero));
    }

    @Test
    void testAddition_NegativeValues() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NullSecondOperand() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> l1.add(null));
    }
}