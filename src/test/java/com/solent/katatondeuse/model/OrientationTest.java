package com.solent.katatondeuse.model;

import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.model.Orientation;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testFromChar() {
        assertEquals(Orientation.N, Orientation.fromChar('N'));
        assertEquals(Orientation.E, Orientation.fromChar('E'));
        assertEquals(Orientation.S, Orientation.fromChar('S'));
        assertEquals(Orientation.W, Orientation.fromChar('W'));
    }

    @Test
    void testFromChar_invalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Orientation.fromChar('X'));
        assertEquals("Invalid orientation character: X", exception.getMessage());
    }

    @Test
    void testFromChar_lowercaseInput() {
        assertThrows(IllegalArgumentException.class, () -> Orientation.fromChar('n'));
    }
}