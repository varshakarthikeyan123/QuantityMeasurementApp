package com.bridgelabz;

import java.util.Objects;

public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

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

    /* =======================
       STATIC CONVERSION API
       ======================= */

    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        // Convert to base unit (feet)
        double valueInFeet = value * source.getConversionFactor();

        // Convert from feet to target unit
        return valueInFeet / target.getConversionFactor();
    }

    /* =======================
       INSTANCE CONVERT METHOD
       ======================= */

    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double convertedValue =
                convert(this.value, this.unit, targetUnit);

        return new QuantityLength(convertedValue, targetUnit);
    }

    /* =======================
       EQUALITY (from UC3/UC4)
       ======================= */

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityLength other = (QuantityLength) obj;

        double thisInFeet =
                this.value * this.unit.getConversionFactor();

        double otherInFeet =
                other.value * other.unit.getConversionFactor();

        return Math.abs(thisInFeet - otherInFeet) < EPSILON;
    }

    @Override
    public int hashCode() {
        double baseValue =
                value * unit.getConversionFactor();
        return Objects.hash(baseValue);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}