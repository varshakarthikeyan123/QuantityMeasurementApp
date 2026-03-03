package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

    /* ================================
       EQUALITY TESTS
       ================================ */

    @Test
    void testCelsiusToFahrenheitEquality() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertTrue(c.equals(f));
    }

    @Test
    void testCelsiusToKelvinEquality() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> k =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

        assertTrue(c.equals(k));
    }

    @Test
    void testNegativeFortyEquality() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(-40.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT);

        assertTrue(c.equals(f));
    }

    /* ================================
       CONVERSION TESTS
       ================================ */

    @Test
    void testCelsiusToFahrenheitConversion() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> converted =
                c.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212.0, converted.getValue());
    }

    @Test
    void testFahrenheitToCelsiusConversion() {
        Quantity<TemperatureUnit> f =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> converted =
                f.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(0.0, converted.getValue());
    }

    @Test
    void testKelvinToCelsiusConversion() {
        Quantity<TemperatureUnit> k =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

        Quantity<TemperatureUnit> converted =
                k.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(0.0, converted.getValue());
    }

    /* ================================
       UNSUPPORTED OPERATIONS
       ================================ */

    @Test
    void testAdditionNotSupported() {
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    @Test
    void testSubtractionNotSupported() {
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    @Test
    void testDivisionNotSupported() {
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }

    /* ================================
       CROSS CATEGORY SAFETY
       ================================ */

    @Test
    void testTemperatureVsLength() {
        Quantity<TemperatureUnit> temp =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<LengthUnit> length =
                new Quantity<>(100.0, LengthUnit.FEET);

        assertFalse(temp.equals(length));
    }

    @Test
    void testTemperatureVsWeight() {
        Quantity<TemperatureUnit> temp =
                new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        Quantity<WeightUnit> weight =
                new Quantity<>(50.0, WeightUnit.KILOGRAM);

        assertFalse(temp.equals(weight));
    }
}