package com.jarlin.facteursPremiers;

import java.util.ArrayList;
import java.util.List;

public class FacteursPremiers {
    public static List<Integer> generate(int nombre) {
        List<Integer> facteurs = new ArrayList<>();
        if (nombre > 1) {
            while (nombre % 2 == 0) {
                facteurs.add(2);
                nombre /= 2;
            }
            if (nombre > 1) {
                facteurs.add(nombre);
            }
        }
        return facteurs;
    }
}
