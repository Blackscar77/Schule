package de.jannes.schule.windpark;

import sas.Circle;
import sas.Rectangle;

import java.awt.*;

public class Windrad {

    Circle circle;
    Rectangle mast;
    Rectangle[] rotor;

    public Windrad(double x, double y) {

        mast = new Rectangle(x, y, 50, 250, Color.GRAY);

        circle = new Circle(mast.getShapeX(), mast.getShapeY() - 40, 25, Color.BLUE);

        rotor = new Rectangle[3];

        for (int i = 0; i < rotor.length; i++) {
            rotor[i] = new Rectangle(circle.getShapeX() + 25, circle.getShapeY() + 25, 250, 25);
            rotor[i].turn(circle.getCenterX(), circle.getCenterY(), i * (360 / rotor.length));
        }
    }

    public void drehe() {
        for (int i = 0; i < rotor.length; i++) {
            rotor[i].turn(circle.getCenterX(), circle.getCenterY(), 1);
        }
    }
}