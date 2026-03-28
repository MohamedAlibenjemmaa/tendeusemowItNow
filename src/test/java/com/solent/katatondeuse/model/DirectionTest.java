package com.solent.katatondeuse.model;

import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.model.Direction;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testFromChar() {
        assertEquals(Direction.A, Direction.fromChar('A'));
        assertEquals(Direction.G, Direction.fromChar('G'));
        assertEquals(Direction.D, Direction.fromChar('D'));
    }

    @Test
    void testFromChar_invalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Direction.fromChar('X'));
        assertEquals("Invalid direction character: X", exception.getMessage());
    }

    @Test
    void testFromChar_lowercaseInput() {
        assertThrows(IllegalArgumentException.class, () -> Direction.fromChar('a'));
        assertThrows(IllegalArgumentException.class, () -> Direction.fromChar('g'));
        assertThrows(IllegalArgumentException.class, () -> Direction.fromChar('d'));
    }
}
