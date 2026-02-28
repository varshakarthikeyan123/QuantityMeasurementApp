package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                QuantityLength.convert(1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testConversion_YardsToFeet() {
        assertEquals(9.0,
                QuantityLength.convert(3.0,
                        LengthUnit.YARDS,
                        LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                QuantityLength.convert(2.54,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.INCHES),
                0.01);
    }

    @Test
    void testInstanceConvertTo() {
        QuantityLength length =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result =
                length.convertTo(LengthUnit.INCHES);

        assertEquals(12.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        1.0, null, LengthUnit.FEET));
    }

    @Test
    void testConversion_NaN_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.NaN,
                        LengthUnit.FEET,
                        LengthUnit.INCHES));
    }
}