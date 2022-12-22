package de.jannes.schule;

import sas.Circle;
import sas.View;

import java.awt.*;

public class OrbitSonne {
    Circle sonne, erde, mond;
    View fenster;

    int sonnensystemX = 400;
    int sonnensystemY = 400;
    int sonneRadius = 30;
    int erdeX = 350;
    int erdeY = 350;
    int erdeRadius = 20;
    int mondX = 500;
    int mondY = 450;
    int mondRadius = 10;

    public static void main(String[] args) {
        OrbitSonne orbitSonne = new OrbitSonne();
        orbitSonne.moveErde();
    }

    public OrbitSonne() {
        sonne = new Circle(sonnensystemX - sonneRadius / 2, sonnensystemY - sonneRadius / 2, sonneRadius, Color.yellow);
        mond = new Circle(sonnensystemX, sonnensystemY, mondRadius, Color.gray);
        erde = new Circle(sonnensystemX - erdeRadius / 2, sonnensystemY - erdeRadius / 2, erdeRadius, Color.blue);
        fenster = new View(800, 800,"OrbitSonne");
    }

    public void moveErde() {
        // Erde:
        int erdepositionX1 = 0, erdepositionX2;
        int erdepositionY1 = 0, erdepositionY2;
        int rotationsRadius = 200;
        double alpha = 0;
        // Mond:
        int MondpositionX1 = 0, MondpositionX2;
        int MondpositionY1 = 0, MondpositionY2;
        int rotationsRadiusMond = 100;
        double alphaMond = 0;

        int i = 1;
        while (i == 1) {
            while (!fenster.keyEnterPressed()) {
                //Erde:
                erdepositionX2 = (int) (rotationsRadius * Math.sin(alpha));
                erdepositionY2 = (int) (rotationsRadius * Math.cos(alpha));
                erde.move(erdepositionX2 - erdepositionX1, erdepositionY2 - erdepositionY1);
                erdepositionX1 = erdepositionX2;
                erdepositionY1 = erdepositionY2;
                alpha = alpha + 0.03;
                //Mond:
                MondpositionX2 = (int) (rotationsRadius * Math.sin(alpha) + rotationsRadiusMond * Math.sin(alphaMond));
                MondpositionY2 = (int) (rotationsRadius * Math.cos(alpha) + rotationsRadiusMond * Math.cos(alphaMond));
                mond.move(MondpositionX2 - MondpositionX1, MondpositionY2 - MondpositionY1);
                MondpositionX1 = MondpositionX2;
                MondpositionY1 = MondpositionY2;
                alphaMond = alphaMond + 0.06;

                fenster.wait(15);
            }
        }
    }
}