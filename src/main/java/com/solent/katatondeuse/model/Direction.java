package com.solent.katatondeuse.model;


/**
 * Three directions for moving a {@link Tondeuse} using a {@link com.solent.katatondeuse.controller.movement.MovementStrategy}  .
 */
public enum Direction {
    D, // Droite (droite)
    G, // Gauche (left)
    A; // Avance (ahead)

    public static Direction fromChar(char c) {
        return switch (c) {
            case 'A' -> A;
            case 'G' -> G;
            case 'D' -> D;
            default -> throw new IllegalArgumentException("Invalid direction character: " + c);
        };
    }
}
