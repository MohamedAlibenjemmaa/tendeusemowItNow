package com.solent.katatondeuse.controller.movement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.controller.movement.MovementRight;
import com.solent.katatondeuse.model.*;

public class MovementRightTest {
    private MovementRight movementRight;
    private Pelouse pelouse;

    @BeforeEach
    void setUp() {
        movementRight = new MovementRight();
        pelouse = new Pelouse(5, 5);
    }

    @Test
    void testTurnRightFromNorth() {
        Tondeuse tondeuse = new Tondeuse(new Position(1, 1, Orientation.N));
        movementRight.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(1, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Orientation.E, pos.getOrientation());
    }

    @Test
    void testTurnRightFromEast() {
        Tondeuse tondeuse = new Tondeuse(new Position(1, 1, Orientation.E));
        movementRight.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(1, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Orientation.S, pos.getOrientation());
    }

    @Test
    void testTurnRightFromSouth() {
        Tondeuse tondeuse = new Tondeuse(new Position(1, 1, Orientation.S));
        movementRight.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(1, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Orientation.W, pos.getOrientation());
    }

    @Test
    void testTurnRightFromWest() {
        Tondeuse tondeuse = new Tondeuse(new Position(1, 1, Orientation.W));
        movementRight.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(1, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Orientation.N, pos.getOrientation());
    }
}
