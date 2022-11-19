package de.jannes.schule;

import sas.Circle;
import sas.Rectangle;
import sas.View;

import java.awt.*;

public class Baumreihe {

    View view;
    Circle circle;
    Rectangle rectangle;

    double scale = 1.0;

    public static void main(String[] args) {
        new Baumreihe();
    }

    public Baumreihe() {
        view = new View(1200, 600, "Baumreihe");

        int i = 0;

        while (i < 11) {

            rectangle = new Rectangle(90 * scale + i * 100 * scale, 100, 20 * scale, 100 * scale, Color.decode("#5b3a29"));

            circle = new Circle(50 * scale + i * 100 * scale, 50, 50 * scale, Color.GREEN);

            i++;
        }
    }
}
