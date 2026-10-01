package com.jarlin.panier;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/*
 * Scénarios : voir la proposition du sujet (1_création, 2_ajouterArticle, 3_supprimerArticle, 4_viderPanier).
 */
class PanierTest {
    private static final double PRECISION = 0.001;

    @Nested
    class Creation {
        @Test
        void devrait_etre_vide_et_d_un_montant_de_0_a_sa_creation() {
            // GIVEN
            var panier = new Panier();
            // WHEN
            var estVide = panier.estVide();
            var montant = panier.getMontantTotal();
            // THEN
            assertThat(estVide).isTrue();
            assertThat(panier.getNombreArticles()).isZero();
            assertThat(montant).isCloseTo(0.0, within(PRECISION));
        }
    }

    @Nested
    class AjouterArticle {
        @Test
        void devrait_contenir_1_article_de_1_50_apres_ajout_d_une_banane_a_1_50() {
            // GIVEN
            var panier = new Panier();
            var banane = new Produit("banane", 1.50);
            // WHEN
            panier.ajouterArticle(banane, 1);
            // THEN
            assertThat(panier.estVide()).isFalse();
            assertThat(panier.getNombreArticles()).isEqualTo(1);
            assertThat(panier.getMontantTotal()).isCloseTo(1.5, within(PRECISION));
        }

        @Test
        void devrait_contenir_2_articles_de_2_50_apres_ajout_de_deux_bananes_de_prix_differents() {
            // GIVEN
            var panier = new Panier();
            var banane150 = new Produit("banane", 1.50);
            var banane100 = new Produit("banane", 1.00);
            // WHEN
            panier.ajouterArticle(banane150, 1);
            panier.ajouterArticle(banane100, 1);
            // THEN
            assertThat(panier.getNombreArticles()).isEqualTo(2);
            assertThat(panier.getMontantTotal()).isCloseTo(2.5, within(PRECISION));
        }

        @Test
        void devrait_contenir_2_articles_de_3_00_apres_ajout_de_2_bananes_a_1_50() {
            // GIVEN
            var panier = new Panier();
            var banane = new Produit("banane", 1.50);
            // WHEN
            panier.ajouterArticle(banane, 2);
            // THEN
            assertThat(panier.getNombreArticles()).isEqualTo(2);
            assertThat(panier.getMontantTotal()).isCloseTo(3.0, within(PRECISION));
        }

        @Test
        void devrait_contenir_3_articles_de_4_00_apres_ajout_de_2_bananes_a_1_50_et_1_banane_a_1_00() {
            // GIVEN
            var panier = new Panier();
            var banane150 = new Produit("banane", 1.50);
            var banane100 = new Produit("banane", 1.00);
            // WHEN
            panier.ajouterArticle(banane150, 2);
            panier.ajouterArticle(banane100, 1);
            // THEN
            assertThat(panier.getNombreArticles()).isEqualTo(3);
            assertThat(panier.getMontantTotal()).isCloseTo(4.0, within(PRECISION));
        }

        @Test
        void devrait_cumuler_les_quantites_quand_on_ajoute_deux_fois_le_meme_produit() {
            // GIVEN
            var panier = new Panier();
            panier.ajouterArticle(new Produit("banane", 1.50), 1);
            // WHEN
            panier.ajouterArticle(new Produit("banane", 1.50), 2);
            // THEN
            assertThat(panier.getNombreArticles()).isEqualTo(3);
            assertThat(panier.getMontantTotal()).isCloseTo(4.5, within(PRECISION));
        }
    }

    @Nested
    class SupprimerArticle {
        @Test
        void devrait_etre_vide_apres_suppression_de_l_unique_article() {
            // GIVEN
            var panier = new Panier();
            var banane = new Produit("banane", 1.50);
            panier.ajouterArticle(banane, 1);
            // WHEN
            panier.supprimerArticle(banane, 1);
            // THEN
            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }

        @Test
        void devrait_contenir_1_article_apres_suppression_de_2_bananes_sur_3() {
            // GIVEN
            var panier = new Panier();
            var banane = new Produit("banane", 1.50);
            panier.ajouterArticle(banane, 3);
            // WHEN
            panier.supprimerArticle(banane, 2);
            // THEN
            assertThat(panier.getNombreArticles()).isEqualTo(1);
            assertThat(panier.getMontantTotal()).isCloseTo(1.5, within(PRECISION));
        }

        @Test
        void devrait_ne_contenir_que_le_chocolat_apres_suppression_des_2_bananes() {
            // GIVEN
            var panier = new Panier();
            var banane = new Produit("banane", 1.50);
            var chocolat = new Produit("chocolat", 10.0);
            panier.ajouterArticle(banane, 2);
            panier.ajouterArticle(chocolat, 1);
            // WHEN
            panier.supprimerArticle(banane, 2);
            // THEN
            assertThat(panier.getNombreArticles()).isEqualTo(1);
            assertThat(panier.getMontantTotal()).isCloseTo(10.0, within(PRECISION));
        }
    }

    @Nested
    class ViderPanier {
        @Test
        void devrait_rester_vide_apres_avoir_vide_un_panier_vide() {
            // GIVEN
            var panier = new Panier();
            // WHEN
            panier.viderPanier();
            // THEN
            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }

        @Test
        void devrait_etre_vide_apres_avoir_vide_un_panier_contenant_des_articles() {
            // GIVEN
            var panier = new Panier();
            panier.ajouterArticle(new Produit("banane", 1.50), 1);
            panier.ajouterArticle(new Produit("chocolat", 10.0), 2);
            // WHEN
            panier.viderPanier();
            // THEN
            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }
    }
}
