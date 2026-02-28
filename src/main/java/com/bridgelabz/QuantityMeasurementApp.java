package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength l1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength l2 =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = l1.add(l2);

        System.out.println(result);
    }
}