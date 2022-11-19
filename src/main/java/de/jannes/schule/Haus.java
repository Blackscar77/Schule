package de.jannes.schule;

import sas.Rectangle;
import sas.View;

import java.awt.*;


public class Haus {

    View view;
    Rectangle base;
    Rectangle door;
    Rectangle fenster;
    Rectangle dach;

    double scale = 1.0;

    public static void main(String[] args) {
        new Haus();
    }

    Haus() {
        view = new View(1200, 600, "Haus");

        dach = new Rectangle(400, 70, 300 * scale, 300 * scale);
        base = new Rectangle(dach.getShapeX() - 50 * scale, dach.getCenterY(), 400 * scale, 300 * scale);
        fenster = new Rectangle(base.getShapeX() + 50 * scale, base.getShapeY() + 125 * scale, 150 * scale, 100 * scale);
        door = new Rectangle(base.getShapeX() + 250 * scale, base.getShapeY() + 125 * scale, 80 * scale, 175 * scale);

        dach.turn(45);

        dach.setColor(Color.RED);
        base.setColor(Color.GRAY);

        fenster.setColor(Color.LIGHT_GRAY);
        door.setColor(Color.DARK_GRAY);
    }

    public void esWerdeNacht() {
        view.setBackgroundColor(Color.BLACK);
        fenster.setColor(Color.YELLOW);
    }

    public void esWerdeTag() {
        view.setBackgroundColor(Color.WHITE);
        fenster.setColor(Color.LIGHT_GRAY);
    }
}