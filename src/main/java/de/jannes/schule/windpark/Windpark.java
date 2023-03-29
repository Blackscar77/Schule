package de.jannes.schule.windpark;

import sas.View;

public class Windpark {

    public static void main(String[] args) {
        new Windpark();
    }

    View view;

    Windrad[] windrad;

    Wind derWind;

    public Windpark() {
        view = new View(1200, 600, "Windpark");

        derWind = new Wind(3);

        windrad = new Windrad[3];

        for (int i = 0; i < windrad.length; i++) {
            windrad[i] = new Windrad(300 * i + 250, 300, derWind);
        }

        while (true) {
            if (view.keyUpPressed()) derWind.windstaerke++;
            if (view.keyDownPressed()) derWind.windstaerke--;

            if (derWind.windstaerke <= -5) derWind.windstaerke = -5;
            if (derWind.windstaerke >= 5) derWind.windstaerke = 5;

            for (int i = 0; i < windrad.length; i++) {
                windrad[i].drehe();
            }

            view.wait(10);
        }
    }
}