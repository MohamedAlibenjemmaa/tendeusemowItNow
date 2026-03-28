package com.solent.katatondeuse.parser;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import com.solent.katatondeuse.model.Direction;
import com.solent.katatondeuse.model.Orientation;
import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Tondeuse;
import com.solent.katatondeuse.parser.FileInputParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileInputParserTest {

    @Test
    void testParseTondeuseInstructions_validInput() {
        String position = "1 2 N";
        String instructions = "AGAD";

        ImmutablePair<Tondeuse, List<Direction>> result = FileInputParser.parseTondeuseInstructions(position, instructions);

        assertNotNull(result);
        assertEquals(1, result.left.getPosition().getX());
        assertEquals(2, result.left.getPosition().getY());
        assertEquals(Orientation.N, result.left.getPosition().getOrientation());

        assertEquals(List.of(Direction.A, Direction.G, Direction.A, Direction.D), result.right);
    }

    @Test
    void testParseTondeuseInstructions_invalidPositionFormat() {
        String invalidPosition = "1 N 2";
        String instructions = "AGAD";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                FileInputParser.parseTondeuseInstructions(invalidPosition, instructions));
        assertEquals("Invalid tondeuse position format : " + invalidPosition, exception.getMessage());
    }

    @Test
    void testParseTondeuseInstructions_invalidInstructionsFormat() {
        String position = "1 2 N";
        String invalidInstructions = "AGZRA";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                FileInputParser.parseTondeuseInstructions(position, invalidInstructions));

        assertEquals("Invalid tondeuse instruction format : " + invalidInstructions, exception.getMessage());
    }


    @Test
    void testParsePelouseDefinition_ValidInput() {
        Pelouse pelouse = FileInputParser.parsePelouseDefinition("5 5");

        assertNotNull(pelouse);
        assertEquals(5, pelouse.getMaxX());
        assertEquals(5, pelouse.getMaxY());
    }

    @Test
    void testParsePelouseDefinition_InvalidInput() {
        String invalidLine = "5x5";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                FileInputParser.parsePelouseDefinition(invalidLine));

        assertTrue(exception.getMessage().contains("Invalid Pelouse size format"));
    }

    @Test
    void testInputParserFile_ValidInputFile() throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();

        String[] args = { tempFile.getAbsolutePath() };
        File result = FileInputParser.parseInputFile(args);

        assertNotNull(result);
        assertTrue(result.exists());
        assertEquals(tempFile.getAbsolutePath(), result.getAbsolutePath());
    }

    @Test
    void testFileInputParser_MissingArgument() {
        String[] args = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FileInputParser.parseInputFile(args);
        });
        assertEquals("Missing input file argument.", exception.getMessage());
    }

    @Test
    void testFileInputParser_NonExistentFile() {
        String[] args = { "nonexistentfile.txt" };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FileInputParser.parseInputFile(args);
        });
        assertEquals("File does not exist: nonexistentfile.txt", exception.getMessage());
    }

}
