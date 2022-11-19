package de.jannes.schule;

import sas.Circle;
import sas.Picture;
import sas.View;

import java.awt.*;

public class Sonnensystem {

    View view;

    Circle sonne, erde, mond;

    Picture background;

    double scale = 1.0;

    public static void main(String[] args) {
        new Sonnensystem();
    }

    public Sonnensystem() {
        view = new View(1200, 600, "Sonnensystem");

        background = new Picture(0, 0, "C:/Users/Jannes/Downloads/1.jpg");

        sonne = new Circle(500, 200, 50 * scale, Color.YELLOW);

        erde = new Circle(sonne.getCenterX() + 150 * scale, sonne.getCenterY() - 25 * scale, 25 * scale, Color.BLUE);

        mond = new Circle(erde.getCenterX() + 75 * scale, erde.getCenterY() - 15 * scale, 15 * scale, Color.GRAY);

        move();
    }


    public void move() {
        while (true) {
            erde.turn(sonne.getCenterX(), sonne.getCenterY(), 0.25);
            mond.turn(erde.getCenterX(), erde.getCenterY(), 3);
            view.wait(10);
            if (view.keyEnterPressed()) {
                break;
            }
        }

        while (true) {
            if (!view.keyEnterPressed()) {
                move();
                break;
            }
        }
    }

    public void reset() {
        sonne.moveTo(500, 200);
        erde.moveTo(sonne.getCenterX() + 150 * scale, sonne.getCenterY() - 25 * scale);
        mond.moveTo(erde.getCenterX() + 75 * scale, erde.getCenterY() - 15 * scale);

        move();
    }
}
