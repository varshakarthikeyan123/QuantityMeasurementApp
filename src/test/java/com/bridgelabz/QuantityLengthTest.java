package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testConvertToBaseUnit() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12),
                0.0001);
    }

    @Test
    void testConvertFromBaseUnit() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1),
                0.0001);
    }

    @Test
    void testEquality() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        assertEquals(a, b);
    }

    @Test
    void testAddWithTargetUnit() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result =
                a.add(b, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), 0.01);
    }
}