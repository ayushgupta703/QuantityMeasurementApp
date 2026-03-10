package com.bridgelabz.quantity_measurement_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.convertToBaseUnit(1));
    }

    @Test
    void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12),
                0.01);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1),
                0.01);
    }

    @Test
    void testEquality_CrossUnit() {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testConversion_YardsToFeet() {

        Quantity<LengthUnit> length =
                new Quantity<>(3.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result =
                length.convertTo(LengthUnit.FEET);

        assertEquals(new Quantity<>(9.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_WithTargetUnit() {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                l1.add(l2, LengthUnit.FEET);

        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    @Test
    void testNullUnitThrows() {

        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testInvalidValueThrows() {

        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    // WEIGHT TESTS

    @Test
    void testWeightEquality_KgToGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testWeightConversion_KgToGram() {

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                weight.convertTo(WeightUnit.GRAM);

        assertEquals(new Quantity<>(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    void testWeightAddition_KgPlusGram() {

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                w1.add(w2);

        assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM), result);
    }
    
 // VOLUME TESTS

    @Test
    void testVolumeEquality_LitreToMilliLitre() {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testVolumeConversion_LitreToMilliLitre() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                volume.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    void testVolumeAddition_LitrePlusMilliLitre() {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                v1.add(v2);

        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }
}