package com.bridgelabz;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double conversionFactor; // relative to FEET

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // UC8 NEW: convert THIS unit → base unit (feet)
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // UC8 NEW: convert base unit (feet) → THIS unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}