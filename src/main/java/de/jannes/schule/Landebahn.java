package de.jannes.schule;

import sas.Circle;
import sas.View;

import java.awt.*;
import java.util.Scanner;

public class Landebahn {

    public static void main(String[] args) {
        new Landebahn();
    }

    View view;
    Circle[] links, rechts;

    int anzahl;

    Landebahn() {

        //Eingabe vom User erhalten
        System.out.println("Wie viele Kreise/Lichter möchtest du erzeugen?");
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
        view = new View(anzahl * 55, anzahl * 55, "Landebahn");
        links = new Circle[anzahl];

        for (int i = 0; i < links.length; i++) {
            links[i] = new Circle(50, i * 55, 25);
            links[i].setColor(Color.black);
        }

        rechts = new Circle[anzahl];

        for (int i = 0; i < rechts.length; i++) {
            rechts[i] = new Circle(250, i * 55, 25);
            rechts[i].setColor(Color.black);
        }

        starteLichterLauf();
    }

    void starteLichterLauf() {
        while (true) {
            for (int i = 0; i < anzahl; i++) {
                links[i].setColor(Color.yellow);
                rechts[i].setColor(Color.yellow);
                view.wait(200);
                links[i].setColor(Color.black);
                rechts[i].setColor(Color.black);
            }
        }
    }

    void starteLichterLauf2() {
        while (true) {
            for (int i = 0; i < anzahl; i++) {
                links[i].setColor(Color.yellow);
                rechts[i].setColor(Color.yellow);
                view.wait(200);
            }

            for (int i = 0; i < anzahl; i++) {
                links[i].setColor(Color.black);
                rechts[i].setColor(Color.black);
                view.wait(200);
            }
        }
    }
}