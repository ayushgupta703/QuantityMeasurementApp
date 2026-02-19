package com.bridgelabz.quantity_measurement_app;

public class QuantityMeasurementApp {

    /*
     * UC2: Feet and Inches Measurement Equality
     */

    // ============================
    // Inner Class: Feet
    // ============================
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // ============================
    // Inner Class: Inches
    // ============================
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (getClass() != obj.getClass())
                return false;

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // ============================
    // Static Methods
    // ============================

    public static void demonstrateFeetEquality() {

        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        boolean result = first.equals(second);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    public static void demonstrateInchesEquality() {

        Inches first = new Inches(1.0);
        Inches second = new Inches(1.0);

        boolean result = first.equals(second);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // ============================
    // Main Method
    // ============================

    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}