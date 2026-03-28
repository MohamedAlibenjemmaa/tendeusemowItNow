package com.solent.katatondeuse.controller;


import java.util.List;
import java.util.Map;

import com.solent.katatondeuse.controller.movement.MovementAhead;
import com.solent.katatondeuse.controller.movement.MovementLeft;
import com.solent.katatondeuse.controller.movement.MovementRight;
import com.solent.katatondeuse.controller.movement.MovementStrategy;
import com.solent.katatondeuse.model.*;
import com.solent.katatondeuse.view.PelouseView;

/**
 * Controls a {@link Tondeuse}  on {@link Pelouse}.
 */
public class TonteTondeuseController {
    private final Pelouse pelouse;
    private final Tondeuse tondeuse;
    private static final Map<Direction, MovementStrategy> MOVEMENTS = Map.of(
            Direction.D, new MovementRight(),
            Direction.G, new MovementLeft(),
            Direction.A, new MovementAhead()
    );

    public TonteTondeuseController(Tondeuse tondeuse, Pelouse pelouse, PelouseView view) {
        this.pelouse = pelouse;
        this.tondeuse = tondeuse;
    }

    /**
     * Executes a list of instructions of movement directions.
     *
     * @param directions the list of movement directions (D, G, A).
     */
    public void executeInstructions(List<Direction> directions) {
        for (Direction direction : directions) {
            MovementStrategy movement = MOVEMENTS.get(direction);
            movement.move(this.pelouse, this.tondeuse);
        }
    }
}