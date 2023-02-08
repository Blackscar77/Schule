package de.jannes.schule;

import sas.Circle;
import sas.View;

import java.awt.*;

public class Helipad {

    public static void main(String[] args) {
        new Helipad();
    }

    View view;

    Circle[] circles;

    Circle laufbahn;

    int anzahl;

    Helipad() {
        anzahl = 18;

        view = new View(1200, 600, "Helipad");

        laufbahn = new Circle(700, 250, 25);

        circles = new Circle[anzahl];

        for (int i = 0; i < anzahl; i++) {
            laufbahn.turn(500, 300, 20);
            circles[i] = new Circle(laufbahn.getShapeX(), laufbahn.getShapeY(), 25);
            circles[i].setColor(Color.black);
        }

        starteLauf();
    }

    void starteLauf() {
        while (true) {
            for (int i = 0; i < anzahl; i++) {
                circles[i].setColor(Color.yellow);
                view.wait(200);
                circles[i].setColor(Color.black);
            }
        }
    }

    void starteLauf2() {
        while (true) {
            for (int i = 0; i < anzahl; i++) {
                circles[i].setColor(Color.yellow);
                view.wait(200);
            }

            for (int i = 0; i < anzahl; i++) {
                circles[i].setColor(Color.black);
                view.wait(200);
            }
        }
    }
}