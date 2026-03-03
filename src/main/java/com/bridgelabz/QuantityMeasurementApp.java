package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ===== UC11 Volume Demo =====

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> v3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println("1 L == 1000 mL ? " + v1.equals(v2));

        System.out.println("1 Gallon in Litre: "
                + v3.convertTo(VolumeUnit.LITRE));

        System.out.println("1 L + 1000 mL = "
                + v1.add(v2));
    }
}