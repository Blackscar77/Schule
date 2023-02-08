package de.jannes.schule;

import sas.Circle;
import sas.Rectangle;
import sas.Text;
import sas.View;

import java.awt.*;

public class PingPong {

    public static void main(String[] args) {
        new PingPong();
    }

    View view;

    Text anleitungSpielerLinks, anleitungSpielerRechts, ergebnis, punkte;

    Circle ball;

    Rectangle oben, unten, links, rechts, spielerLinks, spielerRechts;

    int x = 1;
    int y = 1;

    int punkteSpielerLinks;
    int punkteSpielerRechts;

    PingPong() {
        view = new View(1200, 600, "Ping Pong");

        oben = new Rectangle(100, 100, 1000, 10);

        links = new Rectangle(oben.getShapeX(), oben.getShapeY(), 10, 500);

        rechts = new Rectangle(oben.getShapeX() + 990, oben.getShapeY(), 10, 500);

        unten = new Rectangle(oben.getShapeX(), oben.getShapeY() + 490, 1000, 10);

        spielerLinks = new Rectangle(links.getCenterX() + 20, links.getCenterY() - 50, 10, 100, Color.BLUE);

        spielerRechts = new Rectangle(rechts.getCenterX() - 30, rechts.getCenterY() - 50, 10, 100, Color.RED);

        ball = new Circle(oben.getShapeX() + 490, oben.getShapeY() + 240, 10);

        anleitungSpielerLinks = new Text(oben.getShapeX() + 300, oben.getShapeY() - 100, "Spieler-Links: Drücke 'W' oder 'S' um den Schläger zu bewegen");

        anleitungSpielerRechts = new Text(oben.getShapeX() + 300, oben.getShapeY() - 80, "Spieler-Rechts: Drücke '↑' oder '↓' um den Schläger zu bewegen");

        ergebnis = new Text(oben.getShapeX() + 300, oben.getShapeY() - 60, "Wer wird wohl gewinnen?");

        punkte = new Text(oben.getShapeX() + 300, oben.getShapeY() - 40, "Punkte: Links: " + punkteSpielerLinks + " - Rechts: " + punkteSpielerRechts);


        starteSpiel();
    }

    void starteSpiel() {
        while (true) {
            //Spieler Rechts
            if (view.keyUpPressed() && !spielerRechts.intersects(oben)) {
                spielerRechts.move(0, -1);
            }

            if (view.keyDownPressed() && !spielerRechts.intersects(unten)) {
                spielerRechts.move(0, 1);
            }


            //Spieler Links
            if (view.keyPressed('w') && !spielerLinks.intersects(oben)) {
                spielerLinks.move(0, -1);
            }

            if (view.keyPressed('s') && !spielerLinks.intersects(unten)) {
                spielerLinks.move(0, 1);
            }

            //Reset
            if (view.keyBackspacePressed()) {
                punkteSpielerLinks = 0;
                punkteSpielerRechts = 0;
                ergebnis.setText("Wer wird wohl gewinnen?");
                punkte.setText("Punkte: Links: " + punkteSpielerLinks + " - Rechts: " + punkteSpielerRechts);
                ball.moveTo(oben.getShapeX() + 490, oben.getShapeY() + 240);
            }

            //Ball   
            if (ball.intersects(oben)) {
                y = 1;
            }

            if (ball.intersects(unten)) {
                y = -1;
            }

            if (ball.intersects(links)) {
                x = 1;
                punkteSpielerRechts++;
                ergebnis.setText("Der Rechte Spieler hat gewonnen!");
                punkte.setText("Punkte: Links: " + punkteSpielerLinks + " - Rechts: " + punkteSpielerRechts);
                view.wait(1000);
                ball.moveTo(oben.getShapeX() + 490, oben.getShapeY() + 240);
                starteSpiel();
            }

            if (ball.intersects(rechts)) {
                x = -1;
                punkteSpielerLinks++;
                ergebnis.setText("Der Linke Spieler hat gewonnen!");
                punkte.setText("Punkte: Links: " + punkteSpielerLinks + " - Rechts: " + punkteSpielerRechts);
                view.wait(1000);
                ball.moveTo(oben.getShapeX() + 490, oben.getShapeY() + 240);
                starteSpiel();
            }

            if (ball.intersects(spielerLinks)) {
                x = 1;
            }

            if (ball.intersects(spielerRechts)) {
                x = -1;
            }


            ball.move(x, y);
            view.wait(1);
        }
    }
}