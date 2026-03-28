package com.solent.katatondeuse.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a pelouse (lawn) on which {@link Tondeuse} (mowers) operate.
 */
public class Pelouse {
    private final int maxX;
    private final int maxY;

    private final List<Tondeuse> tondeuses;

    /**
     * Constructs a Pelouse.
     *
     * @param maxX the max x coordinate.
     * @param maxY the max x coordinate.
     */
    public Pelouse(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.tondeuses = new ArrayList<>();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }

    public void addTondeuse(Tondeuse tondeuse) {
        this.tondeuses.add(tondeuse);
    }

    @Override
    public String toString() {
        return String.format("Pelouse{maxX=%d, maxY=%d, tondeuses=%s}", maxX, maxY, tondeuses);
    }
}
