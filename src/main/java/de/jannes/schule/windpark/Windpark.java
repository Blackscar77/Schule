package de.jannes.schule.windpark;

import sas.View;

public class Windpark {

    Windrad[] windrad;

    public static void main(String[] args) {
        new Windpark(10);
    }

    View view;

    int anzahl;

    public Windpark(int geschwindigkeit) {
        view = new View(1200, 600, "Windpark");

        anzahl = 3;

        windrad = new Windrad[anzahl];

        for (int i = 0; i < anzahl; i++) {
            windrad[i] = new Windrad(300 * i + 250, 300);
        }

        while (true) {
            for (int i = 0; i < anzahl; i++) {
                windrad[i].drehe();
            }
            view.wait(geschwindigkeit);
        }
    }
}