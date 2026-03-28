package com.solent.katatondeuse.controller.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.controller.movement.MovementLeft;
import com.solent.katatondeuse.model.*;

public class MovementLeftTest {
    private MovementLeft movementLeft;
    private Pelouse pelouse;

    @BeforeEach
    void setUp() {
        movementLeft = new MovementLeft();
        pelouse = new Pelouse(5, 5);
    }

    @Test
    void testTurnLeftFromNorth() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 3, Orientation.N));
        movementLeft.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(2, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.W, pos.getOrientation());
    }

    @Test
    void testTurnLeftFromWest() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 3, Orientation.W));
        movementLeft.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(2, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.S, pos.getOrientation());
    }

    @Test
    void testTurnLeftFromSouth() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 3, Orientation.S));
        movementLeft.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(2, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.E, pos.getOrientation());
    }

    @Test
    void testTurnLeftFromEast() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 3, Orientation.E));
        movementLeft.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(2, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.N, pos.getOrientation());
    }
}
