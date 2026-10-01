package com.jarlin.fizzbuzz;

public class FizzBuzz {
    public static String de(int nbre) {
        String resultat = "";
        if (nbre % 3 == 0) {
            resultat += "Fizz";
        }
        if (nbre % 5 == 0) {
            resultat += "Buzz";
        }
        return resultat.isEmpty() ? String.valueOf(nbre) : resultat;
    }
}
