package com.solent.katatondeuse.model;

import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.model.Orientation;
import com.solent.katatondeuse.model.Position;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testPositionToString() {
        Position position = new Position(0, 0, Orientation.S);
        String expected = "0 0 S";
        assertEquals(expected, position.toString());
    }
}
