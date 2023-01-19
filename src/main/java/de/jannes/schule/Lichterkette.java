package de.jannes.schule;

import sas.Circle;
import sas.View;

import java.awt.*;
import java.util.Scanner;

public class Lichterkette {

    public static void main(String[] args) {
        new Lichterkette();
    }

    // Deklarationen
    View view;
    Circle[] lichter;

    int anzahl;

    // Konstruktor dieser Klasse
    Lichterkette() {

        //Eingabe vom User erhalten
        Scanner scanner = new Scanner(System.in);

        try {
            //Eingabe vom User als Integer deklarieren
            Integer number = scanner.nextInt();
            anzahl = number;
            System.out.println("Es werden nun " + number + " Kreise/Lichter erzeugt!");
        } catch (Exception e) {
            //Fehler abfangen
            System.out.println("Fehler! Du musst eine Zahl angeben!");
        }


        //anzahl = 10;
        //Initialisierungen
        view = new View(anzahl * 55, 55, "Lichterkette");
        lichter = new Circle[anzahl];

        for (int i = 0; i < lichter.length; i++) {
            lichter[i] = new Circle(i * 55, 5, 25);
            lichter[i].setColor(Color.white);
        }
    }

    // Methoden
    void starteLauflicht() {
        while (!view.keyEnterPressed()) {

            for (int i = 0; i < lichter.length; i++) {
                lichter[i].setColor(Color.red);
                view.wait(200);
            }

            for (int i = 0; i < lichter.length; i++) {
                lichter[i].setColor(Color.white);
                view.wait(200);
            }

        }
    }

    void starteLauflichter2() {
        while (!view.keyEnterPressed()) {

            for (int i = 0; i < lichter.length; i++) {
                lichter[i].setColor(Color.red);
                view.wait(200);
                lichter[i].setColor(Color.white);
            }


            for (int i = lichter.length - 1; i >= 0; i--) {
                lichter[i].setColor(Color.red);
                view.wait(200);
                lichter[i].setColor(Color.white);
            }
        }
    }

    void starteBlinken() {
        while (!view.keyEnterPressed()) {

            for (int i = 0; i < lichter.length; i++) {
                lichter[i].setColor(Color.red);
            }

            view.wait(500);

            for (int i = 0; i < lichter.length; i++) {
                lichter[i].setColor(Color.white);
            }

            view.wait(500);
        }
    }
}