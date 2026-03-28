package com.solent.katatondeuse.view;

import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Tondeuse;

public interface PelouseView {
    /**
     * Displays the current state of the  {@link Pelouse}, including the positions of all {@link Tondeuse}.
     *
     * @param pelouse The {@link Pelouse} to be displayed.
     */
    void displayPelouseState(Pelouse pelouse);

    /**
     * Displays an error message.
     *
     * @param message The error message.
     */
    void displayError(String message);
}
