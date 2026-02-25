package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testFeetToFeetEquality() {
        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 =
                new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToInchesEquality() {
        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testDifferentValues() {
        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 =
                new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }
}