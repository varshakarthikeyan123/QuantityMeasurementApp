package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testYardToFeetEquality() {
        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 =
                new QuantityLength(3.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testYardToInchesEquality() {
        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 =
                new QuantityLength(36.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testCentimeterToInchEquality() {
        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 =
                new QuantityLength(0.393701, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }
}