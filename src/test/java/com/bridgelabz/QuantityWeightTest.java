package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    private static final double EPSILON = 1e-6;

    // ---------------- EQUALITY TESTS ----------------

    @Test
    void testEquality_KilogramToKilogram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_KilogramToGram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_KilogramToPound() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.20462, WeightUnit.POUND)
        );
    }

    @Test
    void testEquality_GramToPound() {
        assertEquals(
                new QuantityWeight(453.592, WeightUnit.GRAM),
                new QuantityWeight(1.0, WeightUnit.POUND)
        );
    }

    @Test
    void testEquality_WithNull() {
        assertNotEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                null
        );
    }


    // ---------------- CONVERSION TESTS ----------------

    @Test
    void testConversion_KgToGram() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_KgToPound() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.getValue(), 0.01);
    }

    @Test
    void testConversion_RoundTrip() {
        QuantityWeight original =
                new QuantityWeight(1.5, WeightUnit.KILOGRAM);

        QuantityWeight result =
                original.convertTo(WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(original.getValue(),
                result.getValue(), EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        QuantityWeight result =
                new QuantityWeight(0.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(0.0, result.getValue(), EPSILON);
    }

    // ---------------- ADDITION TESTS ----------------

    @Test
    void testAddition_SameUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(2.0, WeightUnit.KILOGRAM));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_DefaultUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_Commutativity() {

        QuantityWeight a =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight b =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(
                a.add(b),
                b.add(a)
        );
    }

    @Test
    void testAddition_WithZero() {
        QuantityWeight result =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(0.0, WeightUnit.GRAM));

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityWeight result =
                new QuantityWeight(5.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(-2000.0, WeightUnit.GRAM));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    // ---------------- VALIDATION TESTS ----------------

    @Test
    void testConstructor_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    @Test
    void testConstructor_InvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM));
    }
}