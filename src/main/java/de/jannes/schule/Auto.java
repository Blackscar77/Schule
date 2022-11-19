package de.jannes.schule;

import sas.Rectangle;
import sas.*;

import java.awt.*;


public class Auto {

    View view;
    Ellipse base;

    double scale = 1.0;

    public static void main(String[] args) {
        new Auto();
    }

    Auto() {
        view = new View(1200, 600, "Auto");

        base = new Ellipse(400, 200, 400 * scale, 200 * scale, Color.RED);

        Ellipse dach = new Ellipse(base.getCenterX() - 150 * scale, base.getCenterY() - 200 * scale, 300 * scale, 250 * scale, Color.RED);

        Ellipse windschutzscheibe = new Ellipse(base.getCenterX() - 135 * scale, base.getCenterY() - 175 * scale, 275 * scale, 225 * scale, Color.decode("#89cff0"));

        Rectangle reifen1 = new Rectangle(base.getCenterX() - 210 * scale, base.getCenterY() + 10 * scale, 75 * scale, 100 * scale);

        Rectangle reifen2 = new Rectangle(base.getCenterX() + 135 * scale, base.getCenterY() + 10 * scale, 75 * scale, 100 * scale);

        base.clone();

        Ellipse lichtE1 = new Ellipse(base.getCenterX() - 250 * scale, base.getCenterY() - 75 * scale, 75 * scale, 150 * scale, Color.RED);

        Ellipse lichtE2 = new Ellipse(base.getCenterX() + 175 * scale, base.getCenterY() - 75 * scale, 75 * scale, 150 * scale, Color.RED);

        Circle licht1 = new Circle(base.getCenterX() - 230 * scale, base.getCenterY() - 30 * scale, 30 * scale, Color.YELLOW);

        Circle licht2 = new Circle(base.getCenterX() + 170 * scale, base.getCenterY() - 30 * scale, 30 * scale, Color.YELLOW);

        Ellipse cooler = new Ellipse(base.getCenterX() - 100 * scale, base.getCenterY() - 35 * scale, 200 * scale, 100 * scale, Color.GRAY);

        Rectangle nummernSchild = new Rectangle(base.getCenterX() - 100 * scale, base.getCenterY() + 50 * scale, 200 * scale, 40 * scale, Color.LIGHT_GRAY);

        Text nummerSchildText = new Text(nummernSchild.getShapeX() + 10 * scale, nummernSchild.getShapeY(), "Von David und Jannes");
    }
}