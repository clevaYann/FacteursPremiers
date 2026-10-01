package com.jarlin.facteursPremiers;

public class Main {

    public static void main(String[] args) {
        for (int nombre : new int[]{1, 2, 6, 8, 360}) {
            System.out.println("generate(" + nombre + ") -> " + FacteursPremiers.generate(nombre));
        }
    }
}
