package com.jarlin.personnage;

public class Personnage {
    private Orientation orientation = Orientation.NORD;

    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Fait tourner le personnage de {@code fois} quarts de tour dans le sens des aiguilles d'une montre
     * (une valeur négative le fait tourner dans le sens inverse).
     */
    public Orientation tourner(int fois) {
        Orientation[] orientations = Orientation.values();
        int indice = Math.floorMod(orientation.ordinal() + fois, orientations.length);
        orientation = orientations[indice];
        return orientation;
    }
}
