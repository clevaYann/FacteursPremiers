package com.jarlin.romains;

public class ArabicRomanNumerals {
    private static final int[] VALEURS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLES = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String convert(int nbr) {
        StringBuilder romain = new StringBuilder();
        for (int i = 0; i < VALEURS.length; i++) {
            while (nbr >= VALEURS[i]) {
                romain.append(SYMBOLES[i]);
                nbr -= VALEURS[i];
            }
        }
        return romain.toString();
    }
}
