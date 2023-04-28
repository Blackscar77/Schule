package de.jannes.schule.windpark;

import sas.Text;
import sas.View;

import java.util.Timer;

public class Windpark {

    public static void main(String[] args) {
        new Windpark();
    }

    View view;

    Windrad[] windrad;

    Wind derWind;

    Zeit dieZeit;

    Text text;

    public Windpark() {
        view = new View(1200, 600, "Windpark");

        text = new Text(10, 10, "");

        derWind = new Wind(3);

        windrad = new Windrad[3];

        dieZeit = new Zeit();

        for (int i = 0; i < windrad.length; i++) {
            windrad[i] = new Windrad(300 * i + 250, 300, derWind);
        }

        Timer timer = new Timer();
        timer.schedule(dieZeit, 0, 1 * 1000);

        while (true) {
            text.setText("Zeit: " + dieZeit.time);

            //Zwischen 22 und 6 Uhr bleiben die Windräder Stehen
            if (!(dieZeit.time >= 22 || dieZeit.time <= 6)) {

                //if (view.keyUpPressed()) derWind.setWind(derWind.getWind() + 1);
                //if (view.keyDownPressed()) derWind.setWind(derWind.getWind() - 1);

                if (view.keyUpPressed()) derWind.addWind();
                if (view.keyDownPressed()) derWind.removeWind();

                if (derWind.getWind() <= -9) derWind.setWind(-8);
                if (derWind.getWind() >= 9) derWind.setWind(8);

                for (int i = 0; i < windrad.length; i++) {
                    windrad[i].drehe();
                }
            }

            view.wait(10);
        }
    }
}