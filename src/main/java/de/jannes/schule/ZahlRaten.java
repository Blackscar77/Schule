package de.jannes.schule;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ZahlRaten {

    private static Integer randomNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    private static Integer tries = 0;

    public static void main(String[] args) {
        //System.out.println(randomNumber);
        //guess(77);
        nextRound();
    }

    public static void nextRound() {
        tries++;
        System.out.println();
        System.out.println("Bitte gib eine Zahl ein:");
        Scanner scanner = new Scanner(System.in);
        try {
            Integer number = scanner.nextInt();
            guess(number);
        } catch (Exception e) {
            nextRound();
        }
    }

    public static void guess(Integer number) {
        if (number == randomNumber) {
            System.out.println("Richtig geraten!");
            System.out.println("Anzahl der versuche: " + tries);
        } else {
            System.out.println("Falsch geraten!");

            if (number < randomNumber) {
                System.out.println("Die Zahl ist zu Klein");
            }

            if (number > randomNumber) {
                System.out.println("Die Zahl ist zu Groß");
            }
            nextRound();
        }
    }
}