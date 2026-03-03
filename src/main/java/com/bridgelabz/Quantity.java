package com.bridgelabz;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    /* ================================
       CONSTRUCTOR
       ================================ */

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    /* ================================
       EQUALITY
       ================================ */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!this.unit.getClass().equals(other.unit.getClass())) {
            return false;
        }

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = ((IMeasurable) other.unit).convertToBaseUnit(other.value);

        return Double.compare(base1, base2) == 0;
    }

    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        return Objects.hash(baseValue, unit.getClass());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }

    /* ================================
       CONVERSION
       ================================ */

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = unit.convertToBaseUnit(this.value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    /* ================================
       CENTRALIZED ARITHMETIC (UC13 + UC14)
       ================================ */

    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        public double compute(double a, double b) {
            return operation.applyAsDouble(a, b);
        }
    }

    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetRequired) {

        this.unit.validateOperationSupport("ARITHMETIC");

        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }

        if (!this.unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Different measurement categories");
        }

        if (!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Values must be finite");
        }

        if (targetRequired && targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
    }

    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation op) {
        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        return op.compute(base1, base2);
    }

    private double roundToTwoDecimals(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    /* ================================
       ADD
       ================================ */

    public Quantity<U> add(Quantity<U> other) {
        validateArithmeticOperands(other, this.unit, false);
        double base = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double converted = unit.convertFromBaseUnit(base);
        return new Quantity<>(roundToTwoDecimals(converted), unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double base = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    /* ================================
       SUBTRACT
       ================================ */

    public Quantity<U> subtract(Quantity<U> other) {
        validateArithmeticOperands(other, this.unit, false);
        double base = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double converted = unit.convertFromBaseUnit(base);
        return new Quantity<>(roundToTwoDecimals(converted), unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double base = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    /* ================================
       DIVIDE
       ================================ */

    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, this.unit, false);
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }
}