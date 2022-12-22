package de.jannes.schule;

import sas.Text;
import sas.Tools;
import sas.View;
import sasio.Textfield;

import java.util.concurrent.ThreadLocalRandom;

public class ZahlRatenGui {

    private static final Integer randomNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    private static Integer tries = 0;

    private static final Integer randomnumber1 = Tools.randomNumber(0, 100);

    View view;

    Textfield eingabe;

    Text ausgabe, versuche, hinweis;

    public static void main(String[] args) {
        new ZahlRatenGui();
    }

    public ZahlRatenGui() {
        view = new View(1200, 600, "Zahl Raten");

        eingabe = new Textfield(100, 200, 100, 100, "Eingabe", view);
        eingabe.deleteText();
        eingabe.setActivated(true);
        ausgabe = new Text(100, 100, "Gib eine Zahl an um das Spiel zu starten");
        versuche = new Text(100, 125, "Deine Versuche: " + tries);
        hinweis = new Text(100, 75, "Rate Die Zahl! (0-100)");

        nextRound();
    }

    public void nextRound() {
        while (eingabe.getActivated()) {
            //Es funktioniert, nur wenn eingabe.getText() gesprintet wird --> sehr Merkwürdig
            System.out.println(eingabe.getText());
            if (eingabe.enterPressed()) {
                try {
                    int number = Integer.parseInt(eingabe.getText());
                    tries++;
                    guess(number);
                } catch (NumberFormatException e) {
                    ausgabe.setText("Du musst eine Zahl angeben");
                    eingabe.setActivated(true);
                    nextRound();
                    break;
                }
            }
        }
    }

    public void guess(Integer number) {
        if (number == randomNumber) {
            ausgabe.setText("Richtig geraten! Die Random Zahl war: " + randomNumber);
            versuche.setText("Deine Versuche: " + tries);
            eingabe.setActivated(false);
        } else {
            if (number < randomNumber) {
                ausgabe.setText("Falsch geraten Die Zahl ist zu Klein! Deine vorherige Zahl: " + number);
                versuche.setText("Deine Versuche: " + tries);
            }

            if (number > randomNumber) {
                ausgabe.setText("Falsch geraten Die Zahl ist zu Groß Deine vorherige Zahl:" + number);
                versuche.setText("Anzahl der versuche: " + tries);
            }
            eingabe.deleteText();
            eingabe.setActivated(true);
            nextRound();
        }
    }
}