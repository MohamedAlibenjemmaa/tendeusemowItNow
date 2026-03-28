
package com.solent.katatondeuse.controller.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.controller.movement.MovementAhead;
import com.solent.katatondeuse.model.*;

import static org.junit.jupiter.api.Assertions.*;

class MovementAheadTest {
    private MovementAhead movementAhead;
    private Pelouse pelouse;

    @BeforeEach
    void setUp() {
        movementAhead = new MovementAhead();
        pelouse = new Pelouse(5, 5);
    }

    @Test
    void moveNorth() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 2, Orientation.N));
        movementAhead.move(pelouse, tondeuse);
        Position pos = tondeuse.getPosition();
        assertEquals(2, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.N, pos.getOrientation());
    }

    @Test
    void moveSouth() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 2, Orientation.S));
        movementAhead.move(pelouse, tondeuse);
        Position pos = tondeuse.getPosition();
        assertEquals(2, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Orientation.S, pos.getOrientation());
    }

    @Test
    void moveEast() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 2, Orientation.E));
        movementAhead.move(pelouse, tondeuse);
        Position pos = tondeuse.getPosition();
        assertEquals(3, pos.getX());
        assertEquals(2, pos.getY());
        assertEquals(Orientation.E, pos.getOrientation());
    }

    @Test
    void moveWest() {
        Tondeuse tondeuse = new Tondeuse(new Position(2, 2, Orientation.W));
        movementAhead.move(pelouse, tondeuse);
        Position pos = tondeuse.getPosition();
        assertEquals(1, pos.getX());
        assertEquals(2, pos.getY());
        assertEquals(Orientation.W, pos.getOrientation());
    }

    @Test
    void move_OutOfBounds_MaxY() {
        Tondeuse tondeuse = new Tondeuse(new Position(3, pelouse.getMaxY(), Orientation.N));
        movementAhead.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(3, pos.getX());
        assertEquals(pelouse.getMaxY(), pos.getY());
        assertEquals(Orientation.N, pos.getOrientation());
    }

    @Test
    void move_OutOfBounds_MaxX() {
        Tondeuse tondeuse = new Tondeuse(new Position(pelouse.getMaxX(), 3, Orientation.E));
        movementAhead.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(pelouse.getMaxX(), pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.E, pos.getOrientation());
    }

    @Test
    void move_OutOfBounds_MinY() {
        Tondeuse tondeuse = new Tondeuse(new Position(3, 0, Orientation.S));
        movementAhead.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(3, pos.getX());
        assertEquals(0, pos.getY());
        assertEquals(Orientation.S, pos.getOrientation());
    }

    @Test
    void mov_OutOfBounds_MinX() {
        Tondeuse tondeuse = new Tondeuse(new Position(0, 3, Orientation.W));
        movementAhead.move(pelouse, tondeuse);

        Position pos = tondeuse.getPosition();
        assertEquals(0, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Orientation.W, pos.getOrientation());
    }
}
