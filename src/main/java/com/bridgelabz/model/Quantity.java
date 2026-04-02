package com.bridgelabz.model;

public class Quantity {

    private double value;
    private LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double toBase() {
        return unit.toBase(value);
    }

    public boolean compare(Quantity other) {
        return this.toBase() == other.toBase();
    }

    public Quantity add(Quantity other) {
        double result = this.toBase() + other.toBase();
        return new Quantity(result, LengthUnit.INCHES);
    }
}