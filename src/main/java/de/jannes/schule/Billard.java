package de.jannes.schule;

import sas.Circle;
import sas.Rectangle;
import sas.View;

import java.awt.*;

public class Billard {

    View view;

    Rectangle tisch;

    Circle rot, blau;

    double scale = 1.0;

    public static void main(String[] args) {
        new Billard();
    }

    public Billard() {
        view = new View(1200, 600, "Billard");
        view.wait(1);

        tisch = new Rectangle(200, 100, 800, 400, Color.GREEN);
        szenario1();
    }


    public void szenario1() {
        rot = new Circle(tisch.getCenterX() - 200 * scale, tisch.getCenterY() - 50 * scale, 50 * scale, Color.RED);
        blau = new Circle(tisch.getCenterX() + 100 * scale, tisch.getCenterY() - 50 * scale, 50 * scale, Color.BLUE);

        /*
        while (!rot.intersects(blau)) {
            rot.move(1, 0);
            view.wait(10);
        }
        */

        while (rot.getShapeX() < blau.getShapeX() - 100 * scale && tisch.contains(rot)) {
            rot.move(1, 0);
            view.wait(10);
        }

        int zahl = 10;
        while (blau.getShapeX() > rot.getShapeX() - 100 * scale && tisch.contains(blau) && blau.getShapeX() < 850) {
            zahl++;
            System.out.println(zahl);
            blau.move(1, 0);
            view.wait(zahl);
        }

        //reset();
        //szenario1();
    }

    public void reset() {
        rot.moveTo(tisch.getCenterX() - 200 * scale, tisch.getCenterY() - 50 * scale);
        blau.moveTo(tisch.getCenterX() + 100 * scale, tisch.getCenterY() - 50 * scale);
    }
}