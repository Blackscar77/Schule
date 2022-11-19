package de.jannes.schule;

import sas.Circle;
import sas.Rectangle;
import sas.View;

import java.awt.*;

public class Fussballfeld {

    View fenster;
    Rectangle fussballfeld, tor1, tor2;
    Circle ball;

    double scale = 2.0;

    public static void main(String[] args) {
        new Fussballfeld();
    }

    public Fussballfeld() {
        // Initialisierungen
        fenster = new View(1200, 600, "Fußball");

        fussballfeld = new Rectangle(100, 100, 400 * scale, 200 * scale, Color.GREEN);

        tor1 = new Rectangle(fussballfeld.getShapeX(), fussballfeld.getShapeY() + 50 * scale, 40 * scale, 100 * scale, Color.BLUE);

        tor2 = new Rectangle(fussballfeld.getShapeX() + 360 * scale, fussballfeld.getShapeY() + 50 * scale, 40 * scale, 100 * scale, Color.BLUE);

        ball = new Circle(fussballfeld.getShapeX() + 100 * scale, fussballfeld.getShapeY() + 80 * scale, 20 * scale, Color.RED);

        anstoss();
    }

    public void anstoss() {
        while (fussballfeld.contains(ball)) {
            if (!fenster.keyEnterPressed()) {
                ball.move(1, 0);
            }

            if (fenster.keyEnterPressed()) {
                ball.move(-1, 0);
            }

            fenster.wait(10);
        }
        reset();
        anstoss();
    }

    public void reset() {
        ball.moveTo(fussballfeld.getShapeX() + 100 * scale, fussballfeld.getShapeY() + 80 * scale);
    }
}
