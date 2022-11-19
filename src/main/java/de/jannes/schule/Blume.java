package de.jannes.schule;

import sas.Rectangle;
import sas.*;

import java.awt.*;


public class Blume {

    View view;

    Circle circle;
    Rectangle base;

    public static void main(String[] args) {
        new Blume();
    }

    Blume() {
        view = new View(1200, 600, "Blume");

        base = new Rectangle(500, 200, 50, 300);

        Ellipse ellipse1 = new Ellipse(base.getCenterX() + 40, base.getCenterY() - base.getShapeY() - 50, 70, 150);
        ellipse1.turn(65);
        ellipse1.setColor(Color.RED);

        Ellipse ellipse2 = new Ellipse(base.getCenterX() - 20, base.getCenterY() - base.getShapeY() - 80, 70, 150);
        ellipse2.turn(20);
        ellipse2.setColor(Color.BLUE);

        Ellipse ellipse3 = new Ellipse(base.getCenterX() - 60, base.getCenterY() - base.getShapeY() - 80, 70, 150);
        ellipse3.turn(-20);
        ellipse3.setColor(Color.GREEN);

        Ellipse ellipse4 = new Ellipse(base.getCenterX() - 100, base.getCenterY() - base.getShapeY() - 50, 70, 150);
        ellipse4.turn(-65);
        ellipse4.setColor(Color.YELLOW);

        Ellipse ellipse5 = new Ellipse(base.getCenterX() + 15, base.getCenterY() - 20, 70, 150);
        ellipse5.turn(45);
        ellipse5.setColor(Color.YELLOW);

        Ellipse ellipse6 = new Ellipse(base.getCenterX() - 90, base.getCenterY() - 60, 70, 150);
        ellipse6.turn(-45);
        ellipse6.setColor(Color.YELLOW);

        new Ellipse(110, 170, 200, 60, Color.RED);

        circle = new Circle(base.getShapeX(), base.getShapeY() - 20, 26);

        Text text = new Text(120, 180, "Das ist meine Blume");

        base.setColor(Color.GREEN);
        circle.setColor(Color.YELLOW);
    }
}