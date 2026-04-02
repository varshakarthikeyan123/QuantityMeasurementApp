package com.bridgelabz.model;

public enum LengthUnit {
    FEET(12), INCHES(1);

    private final double conversion;

    LengthUnit(double conversion) {
        this.conversion = conversion;
    }

    public double toBase(double value) {
        return value * conversion;
    }
}