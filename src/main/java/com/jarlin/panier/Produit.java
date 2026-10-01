package com.jarlin.panier;

/**
 * Un produit est identifié par son nom ET son prix unitaire :
 * <"banane", 1.50> et <"banane", 1.00> sont deux produits différents (equals/hashCode générés par le record).
 */
public record Produit(String nom, double prixUnitaire) {
}
