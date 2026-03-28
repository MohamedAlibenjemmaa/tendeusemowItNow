package com.solent.katatondeuse.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.controller.TonteTondeuseController;
import com.solent.katatondeuse.controller.movement.MovementStrategy;
import com.solent.katatondeuse.model.*;
import com.solent.katatondeuse.view.PelouseView;

import java.util.List;

public class TonteTondeuseControllerTest {

    private Pelouse pelouse;
    private Tondeuse tondeuse;
    private PelouseView pelouseView;
    private TonteTondeuseController controller;

    @BeforeEach
    public void setup() {
        pelouse = new Pelouse(5, 5);
        Position initialPosition = new Position(1, 2, Orientation.N);
        tondeuse = new Tondeuse(initialPosition);
        pelouseView = mock(PelouseView.class);
        controller = new TonteTondeuseController(tondeuse, pelouse, pelouseView);
    }

    @Test
    public void testExecuteInstructions() {
        List<Direction> instructions = List.of(Direction.A, Direction.D, Direction.G);

        controller.executeInstructions(instructions);


        Position finalPosition = tondeuse.getPosition();
        assertEquals("1 3 N", finalPosition.toString());
    }
}
