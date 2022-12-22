package de.jannes.schule;

import sas.Rectangle;
import sas.Text;
import sas.View;

import java.awt.*;

public class PfeilUndBogen {

    View view;

    Text text;

    Rectangle pfeil;

    Rectangle spitze;

    Rectangle mitte, fast, fast2, schade, schade2;

    boolean enterPressed;

    public static void main(String[] args) {
        new PfeilUndBogen();
    }

    public PfeilUndBogen() {

        view = new View(1200, 600, "Pfeil und Bogen");

        text = new Text(400, 50, "Drücke Enter um den Pfeil zu schießen");

        pfeil = new Rectangle(100, 250, 100, 15);

        spitze = new Rectangle(pfeil.getShapeX() + 90, pfeil.getShapeY(), 15, 15);

        spitze.turn(45);


        mitte = new Rectangle(900, 300, 25, 50, Color.YELLOW);

        fast = new Rectangle(mitte.getShapeX(), mitte.getShapeY() - 75, 25, 75, Color.ORANGE);

        fast2 = new Rectangle(mitte.getShapeX(), mitte.getShapeY() + 50, 25, 75, Color.ORANGE);

        schade = new Rectangle(mitte.getShapeX(), mitte.getShapeY() - 175, 25, 100, Color.RED);

        schade2 = new Rectangle(mitte.getShapeX(), mitte.getShapeY() + 125, 25, 100, Color.RED);

        boolean hoch;
        hoch = false;

        boolean runter;
        runter = true;

        while (true) {
            if (view.keyEnterPressed()) enterPressed = true;

            if (view.keyBackspacePressed()) reset();

            double y = pfeil.getCenterY();

            //geh runter
            //Wenn y ist zwischen 99 und 101
            //größer als 99 aber kleiner als 101
            if (y >= 99 && y <= 101) {
                hoch = false;
                runter = true;
            }


            //geh hoch
            //Wenn y ist zwischen 499 und 501
            //größer als 499 aber kleiner als 501
            if (y >= 499 && y <= 501) {
                hoch = true;
                runter = false;
            }

            //pfeil nach unten bewegen
            if (!enterPressed && runter) {
                pfeil.move(0, 1);
                spitze.move(0, 1);
                view.wait(3);
            }

            //pfeil nach oben bewegen
            if (!enterPressed && hoch) {
                pfeil.move(0, -1);
                spitze.move(0, -1);
                view.wait(3);
            }


            //||
            //^
            if (enterPressed && !pfeil.intersects(mitte) ^ !pfeil.intersects(fast) ^ !pfeil.intersects(fast2) ^ !pfeil.intersects(schade) ^ !pfeil.intersects(schade2)) {
                pfeil.move(1, 0);
                spitze.move(1, 0);
                view.wait(3);
            }

            if (pfeil.intersects(mitte)) text.setText("Du hast die Goldene Mitte getroffen");

            if (pfeil.intersects(fast) || pfeil.intersects(fast2)) text.setText("Du hast fast die Mitte getroffen");

            if (pfeil.intersects(schade) || pfeil.intersects(schade2))
                text.setText("Schade vielleicht beim nächsten mal");
        }
    }

    public void reset() {
        enterPressed = false;

        text.setText("Drücke Enter um den Pfeil zu schießen");

        pfeil.moveTo(100, 250);

        spitze.turnTo(0);
        spitze.moveTo(pfeil.getShapeX() + 90, pfeil.getShapeY());
        spitze.turnTo(45);
    }
}