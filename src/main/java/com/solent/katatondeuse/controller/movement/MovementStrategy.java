package com.solent.katatondeuse.controller.movement;

import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Tondeuse;

public interface  MovementStrategy {
    /**
     * Executes a movement of a {@link Tondeuse} on the {@link Pelouse}.
     *
     * @param pelouse The {@link Pelouse} on which the {@link Tondeuse} operates.
     * @param tondeuse The {@link Tondeuse} to be moved.
     */
    void move(Pelouse pelouse, Tondeuse tondeuse);
}
