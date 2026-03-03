package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" Quantity Measurement Application ");
        System.out.println("=======================================\n");

        /* =====================================================
           LENGTH DEMONSTRATION
           ===================================================== */

        System.out.println("----- Length Demonstration -----");

        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCH);

        System.out.println("1 FEET equals 12 INCH? " + length1.equals(length2));

        System.out.println("1 FEET in INCH = " +
                length1.convertTo(LengthUnit.INCH));

        System.out.println("1 FEET + 12 INCH = " +
                length1.add(length2));

        System.out.println("1 FEET - 6 INCH = " +
                length1.subtract(new Quantity<>(6.0, LengthUnit.INCH)));

        System.out.println("24 INCH ÷ 2 FEET = " +
                new Quantity<>(24.0, LengthUnit.INCH)
                        .divide(new Quantity<>(2.0, LengthUnit.FEET)));



        /* =====================================================
           WEIGHT DEMONSTRATION
           ===================================================== */

        System.out.println("\n----- Weight Demonstration -----");

        Quantity<WeightUnit> weight1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("1 KG equals 1000 GRAM? " + weight1.equals(weight2));

        System.out.println("1 KG in GRAM = " +
                weight1.convertTo(WeightUnit.GRAM));

        System.out.println("1 KG + 1000 GRAM = " +
                weight1.add(weight2));



        /* =====================================================
           VOLUME DEMONSTRATION (UC11)
           ===================================================== */

        System.out.println("\n----- Volume Demonstration -----");

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("1 LITRE equals 1000 MILLILITRE? "
                + volume1.equals(volume2));

        System.out.println("1 LITRE in GALLON = "
                + volume1.convertTo(VolumeUnit.GALLON));

        System.out.println("1 LITRE + 1000 MILLILITRE = "
                + volume1.add(volume2));



        /* =====================================================
           TEMPERATURE DEMONSTRATION (UC14)
           ===================================================== */

        System.out.println("\n----- Temperature Demonstration -----");

        Quantity<TemperatureUnit> temp1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> temp2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> temp3 =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

        System.out.println("0°C equals 32°F? " + temp1.equals(temp2));
        System.out.println("0°C equals 273.15K? " + temp1.equals(temp3));

        System.out.println("100°C in Fahrenheit = "
                + new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                .convertTo(TemperatureUnit.FAHRENHEIT));

        System.out.println("-40°C equals -40°F? "
                + new Quantity<>(-40.0, TemperatureUnit.CELSIUS)
                .equals(new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT)));

        /* Unsupported operations */

        try {
            temp1.add(temp2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Addition not supported for Temperature: "
                    + e.getMessage());
        }

        try {
            temp1.divide(temp2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Division not supported for Temperature: "
                    + e.getMessage());
        }

        System.out.println("\n=======================================");
        System.out.println(" Application Execution Completed ");
        System.out.println("=======================================");
    }
}