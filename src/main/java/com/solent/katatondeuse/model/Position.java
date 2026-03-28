package com.solent.katatondeuse.model;

/**
 * Represents the position of a {@link Tondeuse} on a 2D grid (x,y) and its
 * orientation (N, E, S, W).
 */
public class Position {
    private final int x;
    private final int y;
    private final Orientation orientation;

    /**
     * Constructs a Position.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @param orientation the orientation (N, E, S, W).
     */
    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return String.format("%d %d %s", x, y, orientation.toString());
    }
}
