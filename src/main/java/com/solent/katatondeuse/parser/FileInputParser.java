package com.solent.katatondeuse.parser;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.solent.katatondeuse.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileInputParser {
    /**
     * Parse instructions for a {@link Tondeuse} initial position and its movement instructions.
     *
     * @param positionLine string representing the {@link Tondeuse} initial position.
     * @param instructionsLine  string representing movement instructions.
     * @return An ImmutablePair of {@link Tondeuse} and {@link Direction}.
     */
    public static ImmutablePair<Tondeuse, List<Direction>> parseTondeuseInstructions(
            String positionLine, String instructionsLine) {
        if (!positionLine.matches("^\\d+ \\d+ [NESW]$")) {
            throw new IllegalArgumentException("Invalid tondeuse position format : " + positionLine);
        }

        if (!instructionsLine.matches("^[AGD]+$")) {
            throw new IllegalArgumentException("Invalid tondeuse instruction format : " + instructionsLine);
        }

        String[] parts = positionLine.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Orientation orientation = Orientation.fromChar(parts[2].charAt(0));

        List<Direction> directions = new ArrayList<>();
        for (char c : instructionsLine.toCharArray()) {
            directions.add(Direction.fromChar(c));
        }

        Tondeuse tondeuse = new Tondeuse(new Position(x, y, orientation));
        return new ImmutablePair<>(tondeuse, directions);
    }

    /**
     * Parse a line to instantiate a {@link Pelouse}.
     *
     * @param line The line of the pelouse definition to parse.
     * @return a Pelouse of the correct format.
     */
    public static Pelouse parsePelouseDefinition(String line) {
        String pattern = "^\\d+ \\d+$";

        if (!line.matches(pattern)) {
            throw new IllegalArgumentException("Invalid Pelouse size format: " + line);
        }

        String[] parts = line.split(" ");
        int xMax = Integer.parseInt(parts[0]);
        int yMax = Integer.parseInt(parts[1]);

        return new Pelouse(xMax, yMax);
    }

    /**
     *  Parses the input arguments to retrieve the input file.
     *
     * @param args cli args.
     * @return a File object representing the input file.
     * @throws IllegalArgumentException if no arguments provided or the file does not exist.
     */
    public static File parseInputFile(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Missing input file argument.");
        }

        File inputFile = new File(args[0]);

        if (!inputFile.exists()) {
            throw new IllegalArgumentException("File does not exist: " + args[0]);
        }

        return inputFile;
    }
}
