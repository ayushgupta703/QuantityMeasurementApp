package com.bridgelabz.quantity_measurement_app.presentation;

import com.bridgelabz.quantity_measurement_app.model.*;
import com.bridgelabz.quantity_measurement_app.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

	private final IQuantityMeasurementService service;

	public QuantityMeasurementController(IQuantityMeasurementService service) {
		this.service = service;
	}

	public void runDemo() {

	    // ---------------- LENGTH ----------------

	    Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
	    Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

	    System.out.println("Is Length Equal?: " + service.compare(l1, l2));

	    System.out.println("Length Conversion (Feet -> Inches): "
	            + service.convert(l1, LengthUnit.INCHES));

	    System.out.println("Addition: " + service.add(l1, l2));

	    System.out.println("Subtraction: " + service.subtract(l1, l2));

	    System.out.println("Division: " + service.divide(l1, l2));

	    System.out.println("\n----------------------------------------\n");


	    // ---------------- WEIGHT ----------------

	    Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
	    Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

	    System.out.println("Is Weight Equal?: " + service.compare(w1, w2));

	    System.out.println("Weight Conversion (KiloGram -> Gram): "
	            + service.convert(w1, WeightUnit.GRAM));

	    System.out.println("Addition: " + service.add(w1, w2));

	    System.out.println("Subtraction: " + service.subtract(w1, w2));

	    System.out.println("Division: " + service.divide(w1, w2));

	    System.out.println("\n----------------------------------------\n");


	    // ---------------- VOLUME ----------------

	    Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
	    Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

	    System.out.println("Is Volume Equal?: " + service.compare(v1, v2));

	    System.out.println("Volume Conversion (Litre -> MilliLitre): "
	            + service.convert(v1, VolumeUnit.MILLILITRE));

	    System.out.println("Addition: " + service.add(v1, v2));

	    System.out.println("Subtraction: " + service.subtract(v1, v2));

	    System.out.println("Division: " + service.divide(v1, v2));

	    System.out.println("\n----------------------------------------\n");


	    // ---------------- TEMPERATURE ----------------

	    Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
	    Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

	    System.out.println("Is Temperature Equal?: " + service.compare(t1, t2));

	    System.out.println("Temperature Conversion (Celsius -> Fahrenheit): "
	            + service.convert(t1, TemperatureUnit.FAHRENHEIT));
	}
}