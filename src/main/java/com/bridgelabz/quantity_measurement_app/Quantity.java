package com.bridgelabz.quantity_measurement_app;

public class Quantity<T extends Measurable> {

    private final double value;
    private final T unit;

    public Quantity(double value, T unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public Quantity<T> convertTo(T targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(round(converted), targetUnit);
    }

    public Quantity<T> add(Quantity<T> other) {
        return add(other, this.unit);
    }

    public Quantity<T> add(Quantity<T> other, T targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");
        
        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double finalValue = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(round(finalValue), targetUnit);
    }

    public Quantity<T> subtract(Quantity<T> other) {
    	return subtract(other, this.unit);
    }
    
    public Quantity<T> subtract(Quantity<T> other, T targetUnit) {
    	
    	if (other == null)
    		throw new IllegalArgumentException("Quantity cannot be null");
    	
    	if (!unit.getClass().equals(other.unit.getClass()))
    	    throw new IllegalArgumentException("Cross-category operation not allowed");
    	
    	double base1 = unit.convertToBaseUnit(value);
    	double base2 = other.unit.convertToBaseUnit(other.value);
    	
    	double subtractBase = base1 - base2;
    	
    	double finalValue = targetUnit.convertFromBaseUnit(subtractBase);
    	
    	return new Quantity<>(round(finalValue), targetUnit);
    }
    
    public double divide(Quantity<T> other) {
    	
    	if (other == null)
    		throw new IllegalArgumentException("Quantity cannot be null");
    	
    	if (!unit.getClass().equals(other.unit.getClass()))
    	    throw new IllegalArgumentException("Cross-category operation not allowed");
    	
    	double base1 = unit.convertToBaseUnit(value);
    	double base2 = other.unit.convertToBaseUnit(other.value);
    	
    	if (base2 == 0) {
    		throw new ArithmeticException("Divisor Cannot Be Zero");
    	}
    	
    	return base1 / base2;
    }

    private boolean compare(Quantity<?> other) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return round(base1) == round(base2);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other))
            return false;
        
        if (!unit.getClass().equals(other.unit.getClass())) {
        	return false;
        }

        return compare(other);
    }
    
    @Override
    public int hashCode() {
    	return Double.hashCode(value) + unit.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}