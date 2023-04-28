package de.jannes.schule.windpark;

import java.util.TimerTask;

public class Zeit extends TimerTask {

    public int time;

    public void run() {
        time++;

        if (time >= 24) time = 0;
    }
}