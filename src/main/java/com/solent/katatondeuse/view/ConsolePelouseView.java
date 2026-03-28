package com.solent.katatondeuse.view;

import com.solent.katatondeuse.model.Pelouse;
import com.solent.katatondeuse.model.Tondeuse;

public class ConsolePelouseView implements PelouseView {
    /**
     * Displays the current state of the  {@link Pelouse}, including the positions of all {@link Tondeuse}.
     *
     * @param pelouse The {@link Pelouse} to be displayed.
     */
    @Override
    public void displayPelouseState(Pelouse pelouse) {
        for (int i = 0; i < pelouse.getTondeuses().size(); i++) {
            Tondeuse tondeuse = pelouse.getTondeuses().get(i);
            System.out.print(tondeuse.getPosition());
            if (i < pelouse.getTondeuses().size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    @Override
    public void displayError(String message) {
        System.err.println(message);
    }
}
