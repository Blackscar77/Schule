package de.jannes.schule;

import sas.Rectangle;
import sas.Text;
import sas.View;

import java.awt.*;

public class PfeilUndBogen {

    View view;

    Text text, score;

    Rectangle pfeil;

    Rectangle spitze;

    Rectangle mitte, fast, fast2, schade, schade2;

    boolean enterPressed;

    int punkte;

    public static void main(String[] args) {
        new PfeilUndBogen();
    }

    public PfeilUndBogen() {

        view = new View(1200, 600, "Pfeil und Bogen");

        text = new Text(400, 50, "Drücke Enter um den Pfeil zu schießen");

        score = new Text(text.getShapeX(), text.getShapeY() + 25, "Deine Punkte: " + punkte);

        pfeil = new Rectangle(100, 250, 100, 10);

        spitze = new Rectangle(pfeil.getShapeX() + 95, pfeil.getShapeY(), 10, 10);

        spitze.turn(45);


        mitte = new Rectangle(900, 300, 25, 50, Color.YELLOW);

        fast = new Rectangle(mitte.getShapeX(), mitte.getShapeY() - 75, 25, 75, Color.ORANGE);

        fast2 = new Rectangle(mitte.getShapeX(), mitte.getShapeY() + 50, 25, 75, Color.ORANGE);

        schade = new Rectangle(mitte.getShapeX(), mitte.getShapeY() - 175, 25, 100, Color.RED);

        schade2 = new Rectangle(mitte.getShapeX(), mitte.getShapeY() + 125, 25, 100, Color.RED);

        boolean hoch = false;

        boolean runter = true;

        while (true) {
            if (view.keyEnterPressed()) enterPressed = true;

            if (view.keyBackspacePressed()) reset();

            if (view.keyPressed('p')) {
                punkte = 0;
                score.setText("Deine Punkte: " + punkte);
            }

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

            if (pfeil.intersects(mitte)) {
                punkte = punkte + 3;
                score.setText("Deine Punkte: " + punkte);
                text.setText("Du hast die Goldene Mitte getroffen");
                view.wait(1000);
                reset();
            }

            if (pfeil.intersects(fast) || pfeil.intersects(fast2)) {
                punkte = punkte + 2;
                score.setText("Deine Punkte: " + punkte);
                text.setText("Knapp daneben ist auch vorbei");
                view.wait(1000);
                reset();
            }

            if (pfeil.intersects(schade) || pfeil.intersects(schade2)) {
                punkte = punkte + 1;
                score.setText("Deine Punkte: " + punkte);
                text.setText("Schade vielleicht beim nächsten mal");
                view.wait(1000);
                reset();
            }
        }
    }

    public void reset() {
        enterPressed = false;

        text.setText("Drücke Enter um den Pfeil zu schießen");

        pfeil.moveTo(100, 250);

        spitze.turnTo(0);
        spitze.moveTo(pfeil.getShapeX() + 95, pfeil.getShapeY());
        spitze.turnTo(45);
    }
}