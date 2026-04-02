package com.bridgelabz.entity;

public class QuantityMeasurementEntity {

    private double value;
    private String unit;
    private String operation;

    public QuantityMeasurementEntity(double value, String unit, String operation) {
        this.value = value;
        this.unit = unit;
        this.operation = operation;
    }

    public double getValue() { return value; }
    public String getUnit() { return unit; }
    public String getOperation() { return operation; }
}