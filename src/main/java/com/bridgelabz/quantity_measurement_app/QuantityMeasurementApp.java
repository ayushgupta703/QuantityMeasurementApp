package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Is Length Equal?: " + l1.equals(l2));
        
        System.out.println("Length Conversion (Feet -> Inches): " + l1.convertTo(LengthUnit.INCHES));
        
        System.out.println("Addition: " + l1.add(l2));
        System.out.println("Addition: " + l1.add(l2, LengthUnit.YARDS));
        
        System.out.println("Subtraction: " + l1.subtract(l2));
        System.out.println("Subtraction: " + l1.subtract(l2, LengthUnit.YARDS));
        
        System.out.println("Division: " + l1.divide(l2));
        
        System.out.println("\n----------------------------------------\n");

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Is Weight Equal?: " + w1.equals(w2));
        
        System.out.println("Weight Conversion (KiloGram -> Gram): " + w1.convertTo(WeightUnit.GRAM));
        
        System.out.println("Addition: " + w1.add(w2));
        System.out.println("Addition: " + w1.add(w2, WeightUnit.POUND));
        
        System.out.println("Subtraction: " + w1.subtract(w2));
        System.out.println("Subtraction: " + w1.subtract(w2, WeightUnit.POUND));
        
        System.out.println("Division: " + w1.divide(w2));
        
        System.out.println("\n----------------------------------------\n");
        
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Is Volume Equal?: " + v1.equals(v2));
        
        System.out.println("Weight Conversion (Litre -> MilliLitre): " + v1.convertTo(VolumeUnit.MILLILITRE));
        
        System.out.println("Addition: " + v1.add(v2));
        System.out.println("Addition: " + v1.add(v2, VolumeUnit.GALLON));
        
        System.out.println("Subtraction: " + v1.subtract(v2));
        System.out.println("Subtraction: " + v1.subtract(v2, VolumeUnit.GALLON));
        
        System.out.println("Division: " + v1.divide(v2));
        
        System.out.println("\n----------------------------------------\n");
        
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("Is Temperature Equal?: " + t1.equals(t2));

        Quantity<TemperatureUnit> converted = t1.convertTo(TemperatureUnit.FAHRENHEIT);

        System.out.println("Temperature Conversion (Celsius -> Fahrenheit): " + converted);
    }
}