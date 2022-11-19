package de.jannes.schule;

import sas.Circle;
import sas.View;

import java.awt.*;

public class Kreise {

    public static void main(String[] args) {

        View view = new View(800, 500, "Grundgerüst");

        int radius = 50;

        Circle circleCyan = new Circle(300, 100, radius, Color.CYAN);

        Circle circleOrange = new Circle(circleCyan.getShapeX() - 50, circleCyan.getShapeY() + 88, radius, Color.ORANGE);

        Circle circleYellow = new Circle(circleCyan.getShapeX() + 50, circleCyan.getShapeY() + 88, radius, Color.YELLOW);

        Circle circleGreen = new Circle(circleOrange.getShapeX() - 50, circleOrange.getShapeY() + 88, radius, Color.GREEN);

        Circle circleRed = new Circle(circleCyan.getShapeX(), circleCyan.getShapeY() + 176, radius, Color.RED);

        Circle circleBlue = new Circle(circleYellow.getShapeX() + 50, circleYellow.getShapeY() + 88, radius, Color.BLUE);
    }
}
