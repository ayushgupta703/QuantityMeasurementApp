package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_DifferentValues() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    void testEquality_SameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    void testEquality_NullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null));
    }
    
    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_CentimeterToInches_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(2.0, Length.LengthUnit.YARDS);
        assertFalse(l1.equals(l2));
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    
    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET),
                1e-6);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_RoundTrip() {
        double original = 5.0;

        double converted = Length.convert(original,
                Length.LengthUnit.FEET,
                Length.LengthUnit.YARDS);

        double back = Length.convert(converted,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.FEET);

        assertEquals(original, back, 1e-6);
    }

    @Test
    void testConversion_ZeroValue() {
        assertEquals(0.0,
                Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_NegativeValue() {
        assertEquals(-12.0,
                Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, null, Length.LengthUnit.INCHES));
    }

    @Test
    void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));
    }
}