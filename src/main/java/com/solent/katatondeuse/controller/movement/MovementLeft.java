package com.solent.katatondeuse.controller.movement;


import com.solent.katatondeuse.model.Orientation;
import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Position;
import com.solent.katatondeuse.model.Tondeuse;

public class MovementLeft implements MovementStrategy {
    /**
     * Rotates the {@link  Tondeuse} 90 degrees to the left.
     *
     * @param pelouse The {@link Pelouse} on which the {@link Tondeuse} operates.
     * @param tondeuse The {@link Tondeuse} to be moved.
     */
    @Override
    public void move(Pelouse pelouse, Tondeuse tondeuse) {
        Position position = tondeuse.getPosition();
        Orientation new_orientation = switch (position.getOrientation()) {
            case N -> Orientation.W;
            case W -> Orientation.S;
            case S -> Orientation.E;
            case E -> Orientation.N;
        };

        tondeuse.setPosition(new Position(position.getX(), position.getY(), new_orientation));
    }
}