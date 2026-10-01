package com.jarlin.panier;

import java.util.HashMap;
import java.util.Map;

public class Panier {
    private final Map<Produit, Integer> articles = new HashMap<>();

    public int getNombreArticles() {
        int nombre = 0;
        for (int quantite : articles.values()) {
            nombre += quantite;
        }
        return nombre;
    }

    public boolean estVide() {
        return articles.isEmpty();
    }

    public double getMontantTotal() {
        double montant = 0.0;
        for (Map.Entry<Produit, Integer> article : articles.entrySet()) {
            montant += article.getKey().prixUnitaire() * article.getValue();
        }
        return montant;
    }

    public void ajouterArticle(Produit produit, int quantite) {
        articles.merge(produit, quantite, Integer::sum);
    }

    public void supprimerArticle(Produit produit, int quantite) {
        int restant = articles.getOrDefault(produit, 0) - quantite;
        if (restant > 0) {
            articles.put(produit, restant);
        } else {
            articles.remove(produit);
        }
    }

    public void viderPanier() {
        articles.clear();
    }
}
