package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        System.out.println(a.add(b, LengthUnit.FEET));
        System.out.println(a.add(b, LengthUnit.INCHES));
        System.out.println(a.add(b, LengthUnit.YARDS));
    }
}