package com.jarlin.facteursPremiers;

import java.util.ArrayList;
import java.util.List;

public class FacteursPremiers {
    public static List<Integer> generate(int nombre) {
        List<Integer> facteurs = new ArrayList<>();
        int diviseur = 2;
        while (nombre > 1) {
            while (nombre % diviseur == 0) {
                facteurs.add(diviseur);
                nombre /= diviseur;
            }
            diviseur++;
        }
        return facteurs;
    }
}
