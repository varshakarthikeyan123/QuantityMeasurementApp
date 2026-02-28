package com.bridgelabz;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // ================= UC5 CONVERT =================
    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException();

        if (source == null || target == null)
            throw new IllegalArgumentException();

        double baseValue =
                value * source.getConversionFactor();

        return baseValue / target.getConversionFactor();
    }

    public QuantityLength convertTo(LengthUnit target) {
        return new QuantityLength(
                convert(this.value, this.unit, target),
                target);
    }

    // ================= UC6 ADD (default first unit) =================
    public QuantityLength add(QuantityLength other) {

        if (other == null)
            throw new IllegalArgumentException();

        double thisFeet =
                this.value * this.unit.getConversionFactor();

        double otherFeet =
                other.value * other.unit.getConversionFactor();

        double sumFeet = thisFeet + otherFeet;

        double result =
                sumFeet / this.unit.getConversionFactor();

        return new QuantityLength(result, this.unit);
    }

    // ================= UC7 ADD (EXPLICIT TARGET UNIT) =================
    public QuantityLength add(QuantityLength other,
                              LengthUnit targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException();

        double thisFeet =
                this.value * this.unit.getConversionFactor();

        double otherFeet =
                other.value * other.unit.getConversionFactor();

        double sumFeet = thisFeet + otherFeet;

        double result =
                sumFeet / targetUnit.getConversionFactor();

        return new QuantityLength(result, targetUnit);
    }

    // ================= EQUALS =================
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityLength other = (QuantityLength) obj;

        double thisFeet =
                this.value * this.unit.getConversionFactor();

        double otherFeet =
                other.value * other.unit.getConversionFactor();

        return Double.compare(thisFeet, otherFeet) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}