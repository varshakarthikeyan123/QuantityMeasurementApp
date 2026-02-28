package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b =
                new QuantityLength(2, LengthUnit.FEET);

        assertEquals(3,
                a.add(b).getValue(), 0.0001);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        assertEquals(2,
                a.add(b).getValue(), 0.0001);
    }

    @Test
    void testConversion_FeetToInches() {

        double result =
                QuantityLength.convert(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        assertEquals(12, result, 0.0001);
    }

    @Test
    void testAddition_WithZero() {

        QuantityLength a =
                new QuantityLength(5, LengthUnit.FEET);
        QuantityLength b =
                new QuantityLength(0, LengthUnit.INCHES);

        assertEquals(5,
                a.add(b).getValue(), 0.0001);
    }

    @Test
    void testAddition_Null() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> a.add(null));
    }
}