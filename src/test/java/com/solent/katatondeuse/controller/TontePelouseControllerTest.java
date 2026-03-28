package com.solent.katatondeuse.controller;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.view.PelouseView;
import java.io.*;

public class TontePelouseControllerTest {

    private PelouseView pelouseViewMock;

    @BeforeEach
    public void setup() {
        pelouseViewMock = mock(PelouseView.class);
    }

    @Test
    public void testRun() throws IOException {
        String fileContent = """
                5 5
                1 2 N
                GAGAGAGAA
                3 3 E
                AADAADADDA
                """;

        File tempFile = File.createTempFile("testInstructions", ".txt");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(fileContent);
        }

        TontePelouseController controller = new TontePelouseController(tempFile, pelouseViewMock);
        controller.run();

        verify(pelouseViewMock, atLeastOnce()).displayPelouseState(any(Pelouse.class));

 }
}
