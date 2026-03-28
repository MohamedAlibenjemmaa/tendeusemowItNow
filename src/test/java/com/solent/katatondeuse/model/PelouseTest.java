package com.solent.katatondeuse.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.model.Orientation;
import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Position;
import com.solent.katatondeuse.model.Tondeuse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PelouseTest {

    private Pelouse pelouse;

    @BeforeEach
    void setUp() {
        pelouse = new Pelouse(5, 5);
    }

    @Test
    void testAddTondeuseAndGetTondeuses() {
        Tondeuse tondeuse = new Tondeuse(new Position(1, 2, Orientation.N));

        pelouse.addTondeuse(tondeuse);
        List<Tondeuse> tondeuses = pelouse.getTondeuses();

        assertEquals(1, tondeuses.size());
        assertSame(tondeuse, tondeuses.get(0));
    }

    @Test
    void testGetTondeuses() {
        assertTrue(pelouse.getTondeuses().isEmpty());
    }

    @Test
    void testGetMaxX_returnsCorrectValue() {
        Pelouse pelouse = new Pelouse(10, 7);

        assertEquals(10, pelouse.getMaxX());
    }

    @Test
    void testGetMaxY_returnsCorrectValue() {
        Pelouse pelouse = new Pelouse(10, 7);

        assertEquals(7, pelouse.getMaxY());
    }

    @Test
    void testToString() {
        Tondeuse tondeuse = new Tondeuse(new Position(3, 4, Orientation.E));
        pelouse.addTondeuse(tondeuse);

        String result = pelouse.toString();

        assertTrue(result.contains("maxX=5"));
        assertTrue(result.contains("maxY=5"));
        assertTrue(result.contains("Tondeuse { position ="));
    }
}
