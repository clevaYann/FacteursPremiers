package com.jarlin.facteursPremiers;

import java.util.ArrayList;
import java.util.List;

public class FacteursPremiers {
    public static List<Integer> generate(int nombre) {
        List<Integer> facteurs = new ArrayList<>();
        for (int diviseur = 2; nombre > 1; diviseur++) {
            for (; nombre % diviseur == 0; nombre /= diviseur) {
                facteurs.add(diviseur);
            }
        }
        return facteurs;
    }
}
