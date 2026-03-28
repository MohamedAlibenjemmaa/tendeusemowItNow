package com.solent.katatondeuse.model;

import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.model.Orientation;
import com.solent.katatondeuse.model.Position;
import com.solent.katatondeuse.model.Tondeuse;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseTest {

    @Test
    void testPositionGetter() {
        Position position = new Position(1, 2, Orientation.N);
        Tondeuse tondeuse = new Tondeuse(position);

        assertEquals(position, tondeuse.getPosition());
    }

    @Test
    void testSetPosition() {

        Position initialPosition = new Position(1, 2, Orientation.N);
        Tondeuse tondeuse = new Tondeuse(initialPosition);

        Position newPosition = new Position(3, 4, Orientation.E);
        tondeuse.setPosition(newPosition);

        assertEquals(newPosition, tondeuse.getPosition());
        assertEquals(3, tondeuse.getPosition().getX());
        assertEquals(4, tondeuse.getPosition().getY());
        assertEquals(Orientation.E, tondeuse.getPosition().getOrientation());
    }

    @Test
    void testTondeuseToString() {
        Position position = new Position(3, 4, Orientation.E);
        Tondeuse tondeuse = new Tondeuse(position);

        String expected = "Tondeuse { position = 3 4 E }";
        assertEquals(expected, tondeuse.toString());
    }


}
