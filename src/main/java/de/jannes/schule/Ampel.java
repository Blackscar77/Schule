package de.jannes.schule;

import sas.Circle;
import sas.Rectangle;
import sas.View;

import java.awt.*;


public class Ampel {

    View view;
    Rectangle base;
    Circle red;
    Circle yellow;
    Circle green;

    double scale = 1.0;

    public static void main(String[] args) {
        new Ampel();
    }

    Ampel() {
        view = new View(1200, 750, "Ampel");

        base = new Rectangle(400, 5, 225 * scale, 700 * scale, Color.BLACK);

        red = new Circle(base.getCenterX() - 100 * scale, base.getCenterY() - 325 * scale, 100 * scale);
        yellow = new Circle(base.getCenterX() - 100 * scale, base.getCenterY() - 100 * scale, 100 * scale);
        green = new Circle(base.getCenterX() - 100 * scale, base.getCenterY() + 125 * scale, 100 * scale);
        standard();
        auto();
    }

    public void auto() {

        try {

            int sekunden = 3;

            Thread.sleep(sekunden * 1000);
            red();
            Thread.sleep(sekunden * 1000);
            redandyellow();
            Thread.sleep(sekunden * 1000);
            green();
            Thread.sleep(sekunden * 1000);
            yellow();
            auto();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void standard() {
        red.setColor(Color.RED);
        yellow.setColor(Color.YELLOW);
        green.setColor(Color.GREEN);
    }

    public void aus() {
        red.setColor(Color.GRAY);
        yellow.setColor(Color.GRAY);
        green.setColor(Color.GRAY);
    }

    public void redandyellow() {
        red.setColor(Color.RED);
        yellow.setColor(Color.YELLOW);
        green.setColor(Color.GRAY);
    }

    public void red() {
        red.setColor(Color.RED);
        yellow.setColor(Color.GRAY);
        green.setColor(Color.GRAY);
    }

    public void yellow() {
        red.setColor(Color.GRAY);
        yellow.setColor(Color.YELLOW);
        green.setColor(Color.GRAY);
    }

    public void green() {
        red.setColor(Color.GRAY);
        yellow.setColor(Color.GRAY);
        green.setColor(Color.GREEN);
    }
}