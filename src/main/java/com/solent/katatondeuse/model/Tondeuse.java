package com.solent.katatondeuse.model;

/**
 * Represents a Tondeuse (mower) with a current {@link Position} on a 2D grid.
 */
public class Tondeuse {
    private Position position;

    /**
     * Constructs a Tondeuse at the given position.
     *
     * @param position the initial position of the Tondeuse.
     */
    public Tondeuse(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("Tondeuse { position = %s }", position.toString());
    }
}
