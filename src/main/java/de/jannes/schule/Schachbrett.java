package de.jannes.schule;

import sas.Rectangle;
import sas.View;

import java.awt.*;

public class Schachbrett {

    View view;

    Rectangle rectangle;

    public static void main(String[] args) {
        new Schachbrett();
    }

    public Schachbrett() {
        view = new View(1200, 600, "Schachbrett");
        view.setBackgroundColor(Color.GRAY);

        int farbe = 0;

        int reihe = 1;
        int spalte = 1;

        while (reihe <= 8) {
            rectangle = new Rectangle(50 + reihe * 50, 50 + spalte * 50, 50, 50);

            //O = Weiß
            //1 = Schwarz
            if (farbe == 0) {
                rectangle.setColor(Color.WHITE);
                farbe = 1;
            } else {
                rectangle.setColor(Color.BLACK);
                farbe = 0;
            }

            if (reihe == 8) {
                if (spalte < 8) {
                    spalte++;
                    reihe = 0;

                    if (farbe == 0) {
                        farbe = 1;
                    } else {
                        farbe = 0;
                    }
                }
            }

            reihe++;
            view.wait(100);
        }
    }
}