package de.jannes.schule;

import sas.*;

import java.awt.*;
import java.util.Scanner;

public class Binaercode {

    public static void main(String[] args) {
        new Binaercode();
    }

    View view;

    Circle[] circles;

    Text text;

    int zahl;

    char[] c;

    Binaercode() {
        System.out.println("Bitte gib eine Zahl ein:");
        Scanner scanner = new Scanner(System.in);
        try {
            zahl = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Fehler! Du musst eine Zahl angeben!");
        }

        /*
        //Start von Hinten
        for (int i = binaryString.length(); i > 0; i--) {
            System.out.println(c[i - 1]);
        }

         */

/*
        //Start von Vorne
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

 */

        view = new View(500, 100, "Binärcode");

        circles = new Circle[8];

        text = new Text(10, 60, "Der angezeigte Binär Code ist für die Zahl: " + zahl);

        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(2 + i * 55, 5, 25);
            circles[i].setColor(Color.black);
        }

        genZahl();
    }

    public void genZahl() {
        for (int i = 0; i < circles.length; i++) {
            circles[i].setColor(Color.black);
        }

        String binaryString = Integer.toBinaryString(zahl);
        System.out.println("Die Binär Zahl  für " + zahl + " ist: " + binaryString);

        System.out.println("Binary String Length: " + binaryString.length());
        c = binaryString.toCharArray();
        System.out.println("Char Array Length: " + c.length);

        text.setText("Der angezeigte Binär Code ist für die Zahl: " + zahl);

        for (int i = c.length; i > 0; i--) {
            int kreisPosition = i;
            if (c.length == 8) kreisPosition = kreisPosition - 1;
            if (c.length == 7) kreisPosition = kreisPosition + 0;
            if (c.length == 6) kreisPosition = kreisPosition + 1;
            if (c.length == 5) kreisPosition = kreisPosition + 2;
            if (c.length == 4) kreisPosition = kreisPosition + 3;
            if (c.length == 3) kreisPosition = kreisPosition + 4;
            if (c.length == 2) kreisPosition = kreisPosition + 5;
            if (c.length == 1) kreisPosition = kreisPosition + 6;

            circles[kreisPosition].setColor(charToColor(c[i - 1]));
        }
    }

    public void zaehleHoch() {
        for (int i = 0; i <= 255; i++) {
            zahl = i;
            genZahl();
            view.wait(1000);
        }
    }

    private Color charToColor(char c) {
        if (c == '1') {
            return Color.yellow;
        } else {
            return Color.black;
        }
    }
}