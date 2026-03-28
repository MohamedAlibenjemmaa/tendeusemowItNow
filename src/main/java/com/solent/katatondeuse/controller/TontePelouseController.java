package com.solent.katatondeuse.controller;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.solent.katatondeuse.model.Direction;
import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Tondeuse;
import com.solent.katatondeuse.parser.FileInputParser;
import com.solent.katatondeuse.view.PelouseView;

import java.io.*;
import java.util.List;

public class TontePelouseController {
    private final File instructionsFile;
    private final PelouseView pelouseView;

    public TontePelouseController(File instructionsFile, PelouseView view) {
        this.instructionsFile = instructionsFile;
        this.pelouseView = view;
    }

    /**
     * Starts the tonte (mowing) simulation by reading instructions from the input file.
     *
     * @throws IOException an I/O error occurs.
     */
    public void run() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(instructionsFile))) {
            Pelouse pelouse = initPelouse(reader);
            executeInstructions(reader, pelouse);
        }
    }

    /**
     * Reads and executes the  {@link Tondeuse} movement instructions from the reader.
     *
     * @param reader BufferedReader for reading lines from the instructions file.
     * @param pelouse The {@link Pelouse} on which {@link Tondeuse} operate.
     * @throws IOException an I/O error occurs.
     */
    private void executeInstructions(BufferedReader reader, Pelouse pelouse) throws IOException {
        String positionLine;
        while ((positionLine = reader.readLine()) != null) {
            String instructionsLine = reader.readLine();
            ImmutablePair<Tondeuse, List<Direction>> instructions =
                    FileInputParser.parseTondeuseInstructions(positionLine, instructionsLine);
            Tondeuse tondeuse = instructions.left;
            List<Direction> directions = instructions.right;

            pelouse.addTondeuse(tondeuse);

            TonteTondeuseController controller = new TonteTondeuseController(tondeuse, pelouse, this.pelouseView);
            controller.executeInstructions(directions);
        }pelouseView.displayPelouseState(pelouse);
    }

    /**
     * Parses the first line of the input to initialize the .
     *
     * @param reader BufferedReader reading from the instructions file.
     * @return The initialized {@link Pelouse}.
     * @throws IOException an I/O error occurs.
     */
    private Pelouse initPelouse(BufferedReader reader) throws IOException {
        String firstLine = reader.readLine();
        Pelouse pelouse = FileInputParser.parsePelouseDefinition(firstLine);
        //pelouseView.displayPelouseState(pelouse);
        return pelouse;
    }
}