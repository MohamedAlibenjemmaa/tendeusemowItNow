package com.solent.katatondeuse.model;


/**
 * Four cardinal directions for orientations of the {@link Tondeuse}.
 */
public enum Orientation {
    N, // North
    E, // East
    W, // West
    S; // South

    public static Orientation fromChar(char c) {
        return switch (c) {
            case 'N' -> N;
            case 'E' -> E;
            case 'S' -> S;
            case 'W' -> W;
            default -> throw new IllegalArgumentException("Invalid orientation character: " + c);
        };
    }
}
