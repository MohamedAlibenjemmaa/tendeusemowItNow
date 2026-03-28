package com.solent.katatondeuse;

import java.io.File;
import java.io.IOException;

import com.solent.katatondeuse.controller.TontePelouseController;
import com.solent.katatondeuse.parser.FileInputParser;
import com.solent.katatondeuse.view.ConsolePelouseView;
import com.solent.katatondeuse.view.PelouseView;

public class Main {
    public static void main(String[] args) {

        int exitCode = run(args);
        System.exit(exitCode);
    }

    public static int run(String[] args) {
        PelouseView view = new ConsolePelouseView();
        try {
            File inputFile = FileInputParser.parseInputFile(args);
            TontePelouseController controller = new TontePelouseController(inputFile, view);
            controller.run();
        } catch (IllegalArgumentException e) {
            view.displayError("Error: " + e.getMessage());
            view.displayError("Usage: java Main <inputfile>");
            return 1;
        } catch (IOException e) {
            view.displayError("Error reading file: " + e.getMessage());
            return 1;
        }
        return 0;
    }
}