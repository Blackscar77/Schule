package de.jannes.schule;

import sas.Rectangle;
import sas.View;

import java.awt.*;

public class Deutschlandflagge {

    View view;
    Rectangle oben;
    Rectangle mitte;
    Rectangle unten;
    Rectangle mast;
    Rectangle rahmen;

    double scale = 1.5;

    public static void main(String[] args) {
        new Deutschlandflagge();
    }

    Deutschlandflagge() {
        view = new View(1200, 600, "Deutschland Flagge");

        double breite = 200 * scale;
        double hoehe = 50 * scale;

        oben = new Rectangle(100, 100, breite, hoehe);
        rahmen = new Rectangle(oben.getShapeX() - 10 * scale, oben.getShapeY() - 10 * scale, breite + 20 * scale, hoehe * 3 + 20 * scale);
        mast = new Rectangle(oben.getShapeX() - 10 * scale, oben.getShapeY() - 10 * scale, 20 * scale, hoehe * 7 * scale);
        mitte = new Rectangle(oben.getShapeX(), oben.getShapeY() + 50 * scale, breite, hoehe);
        unten = new Rectangle(mitte.getShapeX(), mitte.getShapeY() + 50 * scale, breite, hoehe);

        oben.setColor(Color.BLACK);
        mitte.setColor(Color.RED);
        unten.setColor(Color.YELLOW);
    }
}
