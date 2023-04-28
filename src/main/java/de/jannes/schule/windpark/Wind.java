package de.jannes.schule.windpark;

public class Wind {
    private int windstaerke;

    public Wind(int pwindstaerke) {
        windstaerke = pwindstaerke;
    }

    //Getter
    public int getWind() {
        return windstaerke;
    }

    //Setter
    public void setWind(int pWind) {
        windstaerke = pWind;
    }

    public void addWind() {
        windstaerke++;
    }

    public void removeWind() {
        windstaerke--;
    }
}