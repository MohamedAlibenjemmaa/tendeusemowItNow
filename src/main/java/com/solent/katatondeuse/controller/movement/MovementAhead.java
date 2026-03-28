package com.solent.katatondeuse.controller.movement;

import com.solent.katatondeuse.model.Orientation;
import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Position;
import com.solent.katatondeuse.model.Tondeuse;

public class MovementAhead implements MovementStrategy {
    /**
     * Moves the {@link Tondeuse} one step ahead in the direction of its current orientation.
     *
     * @param pelouse The {@link Pelouse} on which the {@link Tondeuse} operates.
     * @param tondeuse The {@link Tondeuse} to be moved.
     */
    @Override
    public void move(Pelouse pelouse, Tondeuse tondeuse) {
        Position current = tondeuse.getPosition();
        int x = current.getX();
        int y = current.getY();
        Orientation orientation = current.getOrientation();

        switch (orientation) {
            case N -> y += 1;
            case S -> y -= 1;
            case E -> x += 1;
            case W -> x -= 1;
        }

        if (x >= 0 && x <= pelouse.getMaxX() && y >= 0 && y <= pelouse.getMaxY()) {
            tondeuse.setPosition(new Position(x, y, orientation));
        } else {
            System.err.println("Move ignored: out of grid bounds.");
        }
    }
}