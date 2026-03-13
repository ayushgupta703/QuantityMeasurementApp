package com.bridgelabz.quantity_measurement_app.presentation;

import com.bridgelabz.quantity_measurement_app.model.LengthUnit;
import com.bridgelabz.quantity_measurement_app.model.Quantity;
import com.bridgelabz.quantity_measurement_app.presentation.QuantityMeasurementController;

import java.util.Scanner;

@SuppressWarnings("unused")
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementController controller =
                new QuantityMeasurementController();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Quantity Measurement System =====");
            System.out.println("1 Compare Quantities");
            System.out.println("2 Convert Quantity");
            System.out.println("3 Add Quantities");
            System.out.println("4 Subtract Quantities");
            System.out.println("5 Divide Quantities");
            System.out.println("6 View All Saved Operations");
            System.out.println("7 Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    Quantity<LengthUnit> q1 =
                            new Quantity<>(1.0, LengthUnit.FEET);

                    Quantity<LengthUnit> q2 =
                            new Quantity<>(12.0, LengthUnit.INCHES);

                    boolean equal = q1.equals(q2);

                    System.out.println("Comparison Result: " + equal);

                    controller.saveMeasurement(
                            1.0,
                            "FEET",
                            "LENGTH",
                            "EQUALS",
                            String.valueOf(equal)
                    );

                    break;

                case 2:

                    Quantity<LengthUnit> length =
                            new Quantity<>(3.0, LengthUnit.YARDS);

                    Quantity<LengthUnit> converted =
                            length.convertTo(LengthUnit.FEET);

                    System.out.println("Conversion Result: " + converted);

                    controller.saveMeasurement(
                            3.0,
                            "YARDS",
                            "LENGTH",
                            "CONVERT",
                            converted.toString()
                    );

                    break;

                case 3:

                    Quantity<LengthUnit> a =
                            new Quantity<>(1.0, LengthUnit.FEET);

                    Quantity<LengthUnit> b =
                            new Quantity<>(12.0, LengthUnit.INCHES);

                    Quantity<LengthUnit> addResult = a.add(b);

                    System.out.println("Addition Result: " + addResult);

                    controller.saveMeasurement(
                            1.0,
                            "FEET",
                            "LENGTH",
                            "ADD",
                            addResult.toString()
                    );

                    break;

                case 4:

                    Quantity<LengthUnit> s1 =
                            new Quantity<>(10.0, LengthUnit.FEET);

                    Quantity<LengthUnit> s2 =
                            new Quantity<>(6.0, LengthUnit.INCHES);

                    Quantity<LengthUnit> subResult = s1.subtract(s2);

                    System.out.println("Subtraction Result: " + subResult);

                    controller.saveMeasurement(
                            10.0,
                            "FEET",
                            "LENGTH",
                            "SUBTRACT",
                            subResult.toString()
                    );

                    break;

                case 5:

                    Quantity<LengthUnit> d1 =
                            new Quantity<>(24.0, LengthUnit.INCHES);

                    Quantity<LengthUnit> d2 =
                            new Quantity<>(2.0, LengthUnit.FEET);

                    double divResult = d1.divide(d2);

                    System.out.println("Division Result: " + divResult);

                    controller.saveMeasurement(
                            24.0,
                            "INCHES",
                            "LENGTH",
                            "DIVIDE",
                            String.valueOf(divResult)
                    );

                    break;

                case 6:

                    controller.displayAllMeasurements();
                    break;

                case 7:

                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}