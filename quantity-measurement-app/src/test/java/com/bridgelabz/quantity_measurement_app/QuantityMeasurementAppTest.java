package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    // -----------------------
    // UC7 Explicit Target Tests
    // -----------------------

    @Test
    void testAddition_ExplicitTarget_Feet() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.FEET);

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    void testAddition_ExplicitTarget_Inches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.INCHES);

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_ExplicitTarget_Yards() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.YARDS);

        assertEquals(new Length(0.6666666667, Length.LengthUnit.YARDS),
                result.convertTo(Length.LengthUnit.YARDS));
    }

    @Test
    void testAddition_ExplicitTarget_Centimeters() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp
                .demonstrateLengthAddition(
                        l1, l2, Length.LengthUnit.CENTIMETERS);

        double expected = 60.96; // 2 feet in cm
        assertEquals(expected,
                result.convertTo(Length.LengthUnit.CENTIMETERS).getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTarget_NullTarget() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class,
                () -> QuantityMeasurementApp
                        .demonstrateLengthAddition(l1, l2, null));
    }

    @Test
    void testAddition_ExplicitTarget_Commutativity() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result1 = a.add(b, Length.LengthUnit.YARDS);
        Length result2 = b.add(a, Length.LengthUnit.YARDS);

        assertEquals(result1, result2);
    }
}