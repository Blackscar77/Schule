package de.jannes.schule;

import sas.Circle;
import sas.Rectangle;
import sas.View;

import java.awt.*;

public class Kontrollstrukturen {


    View view;

    Circle circle;

    Rectangle rectangle;

    public static void main(String[] args) {
        new Kontrollstrukturen();
    }

    public Kontrollstrukturen() {
        view = new View(1200, 600);
        rectangle = new Rectangle(0, 0, 1200, 600, Color.WHITE);
        circle = new Circle(100, 100, 50);

        while (!view.keyEnterPressed()) {
            if (view.keyPressed('x')) {
                circle.setColor(Color.CYAN);
            } else {
                if (view.keyPressed('y')) {
                    circle.setColor(Color.ORANGE);
                } else {
                    if (view.keyPressed('z')) {
                        circle.setColor(Color.lightGray);
                    }
                }
            }

            if (!rectangle.contains(circle)) {
                circle.moveTo(100, 100);
            }

            circle.move(0, 1);
            view.wait(10);
        }
    }
}