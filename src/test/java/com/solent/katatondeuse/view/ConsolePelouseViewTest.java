package com.solent.katatondeuse.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.controller.movement.MovementAhead;
import com.solent.katatondeuse.model.*;
import com.solent.katatondeuse.view.ConsolePelouseView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsolePelouseViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final ConsolePelouseView view = new ConsolePelouseView();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    void testDisplayPelouseState() {
        Pelouse pelouse = new Pelouse(3, 3);
        pelouse.addTondeuse(new Tondeuse(new Position(0, 0, Orientation.S)));
        pelouse.addTondeuse(new Tondeuse(new Position(2, 2, Orientation.E)));

        view.displayPelouseState(pelouse);

        
        String output = outContent.toString().trim();
        assertTrue(output.contains("0 0 S 2 2 E"));
    }


    @Test
    void testDisplayError() {
        view.displayError("Test error message");

        String output = errContent.toString().trim();
        assertEquals("Test error message", output);
    }
}
