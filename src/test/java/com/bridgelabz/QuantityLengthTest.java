package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testAddition_Target_Feet() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result =
                a.add(b, LengthUnit.FEET);

        assertEquals(2, result.getValue(), 0.0001);
    }

    @Test
    void testAddition_Target_Inches() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result =
                a.add(b, LengthUnit.INCHES);

        assertEquals(24, result.getValue(), 0.0001);
    }

    @Test
    void testAddition_Target_Yards() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result =
                a.add(b, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), 0.01);
    }

    @Test
    void testAddition_NullTarget() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class,
                () -> a.add(b, null));
    }
}