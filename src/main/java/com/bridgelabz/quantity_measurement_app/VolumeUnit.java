package com.bridgelabz.quantity_measurement_app;

public enum VolumeUnit implements Measurable {
	LITRE(1.0),
	MILLILITRE(0.001),
	GALLON(3.78541);
	
	
	private final double conversionFactorToKg;

    VolumeUnit(double conversionFactorToKg) {
        this.conversionFactorToKg = conversionFactorToKg;
    }
	
	@Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToKg;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToKg;
    }
}
