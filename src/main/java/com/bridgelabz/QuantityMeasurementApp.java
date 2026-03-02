package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        // Equality
        System.out.println(w1.equals(w2)); // true

        // Conversion
        System.out.println(w1.convertTo(WeightUnit.POUND));

        // Addition (default unit)
        System.out.println(w1.add(w2));

        // Addition with target unit
        System.out.println(w1.add(w2, WeightUnit.GRAM));
    }
}