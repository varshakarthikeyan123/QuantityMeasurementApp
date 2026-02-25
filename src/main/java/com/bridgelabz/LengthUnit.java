package com.bridgelabz;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084); // 1 cm = 0.0328084 feet

    private final double toFeet;

    LengthUnit(double toFeet) {
        this.toFeet = toFeet;
    }

    public double toFeet(double value) {
        return value * toFeet;
    }
}