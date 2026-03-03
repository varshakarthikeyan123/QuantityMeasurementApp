package com.bridgelabz;

public interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    /* ================================
       UC14 – OPTIONAL ARITHMETIC SUPPORT
       ================================ */

    default boolean supportsArithmetic() {
        return true; // All units support arithmetic by default
    }

    default void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException(
                    getUnitName() + " does not support " + operation + " operation."
            );
        }
    }
}