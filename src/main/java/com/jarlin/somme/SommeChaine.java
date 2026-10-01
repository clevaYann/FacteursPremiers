package com.jarlin.somme;

public class SommeChaine {
    /**
     * Retourne la somme des entiers d'une chaîne de la forme "1,2,3".
     * Une chaîne vide (ou null) vaut 0 ; les espaces autour des nombres sont ignorés.
     */
    public static int somme(String nombres) {
        if (nombres == null || nombres.isBlank()) {
            return 0;
        }
        int somme = 0;
        for (String nombre : nombres.split(",")) {
            somme += Integer.parseInt(nombre.trim());
        }
        return somme;
    }

    /** Variante VarArgs : somme de plusieurs chaînes, ex. somme("1,2", "3") -> 6. */
    public static int somme(String... chaines) {
        int somme = 0;
        for (String chaine : chaines) {
            somme += somme(chaine);
        }
        return somme;
    }
}
