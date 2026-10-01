package com.jarlin.panier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/*
 * Scénarios : voir la proposition du sujet (1_création, 2_ajouterArticle, 3_supprimerArticle, 4_viderPanier).
 */
public class PanierTest {
    private static final double PRECISION = 0.001;

    private final Produit banane150 = new Produit("banane", 1.50);
    private final Produit banane100 = new Produit("banane", 1.00);
    private final Produit chocolat = new Produit("chocolat", 10.0);

    private Panier panier;

    @BeforeEach
    void setUp() {
        panier = new Panier();
    }

    @Nested
    class Creation {
        @Test
        void un_nouveau_panier_devrait_etre_vide_et_d_un_montant_de_0() {
            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getNombreArticles()).isZero();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }
    }

    @Nested
    class AjouterArticle {
        @Test
        void cycle1_ajouter_1_banane_150() {
            panier.ajouterArticle(banane150, 1);

            assertThat(panier.estVide()).isFalse();
            assertThat(panier.getNombreArticles()).isEqualTo(1);
            assertThat(panier.getMontantTotal()).isCloseTo(1.5, within(PRECISION));
        }

        @Test
        void cycle2_ajouter_1_banane_150_et_1_banane_100() {
            panier.ajouterArticle(banane150, 1);
            panier.ajouterArticle(banane100, 1);

            assertThat(panier.getNombreArticles()).isEqualTo(2);
            assertThat(panier.getMontantTotal()).isCloseTo(2.5, within(PRECISION));
        }

        @Test
        void cycle3_ajouter_2_bananes_150() {
            panier.ajouterArticle(banane150, 2);

            assertThat(panier.getNombreArticles()).isEqualTo(2);
            assertThat(panier.getMontantTotal()).isCloseTo(3.0, within(PRECISION));
        }

        @Test
        void cycle4_ajouter_2_bananes_150_et_1_banane_100() {
            panier.ajouterArticle(banane150, 2);
            panier.ajouterArticle(banane100, 1);

            assertThat(panier.getNombreArticles()).isEqualTo(3);
            assertThat(panier.getMontantTotal()).isCloseTo(4.0, within(PRECISION));
        }

        @Test
        void ajouter_deux_fois_le_meme_produit_devrait_cumuler_les_quantites() {
            panier.ajouterArticle(banane150, 1);
            panier.ajouterArticle(new Produit("banane", 1.50), 2);

            assertThat(panier.getNombreArticles()).isEqualTo(3);
            assertThat(panier.getMontantTotal()).isCloseTo(4.5, within(PRECISION));
        }
    }

    @Nested
    class SupprimerArticle {
        @Test
        void cycle1_supprimer_l_unique_banane_150() {
            panier.ajouterArticle(banane150, 1);

            panier.supprimerArticle(banane150, 1);

            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }

        @Test
        void cycle2_supprimer_2_bananes_150_sur_3() {
            panier.ajouterArticle(banane150, 3);

            panier.supprimerArticle(banane150, 2);

            assertThat(panier.getNombreArticles()).isEqualTo(1);
            assertThat(panier.getMontantTotal()).isCloseTo(1.5, within(PRECISION));
        }

        @Test
        void cycle3_supprimer_2_bananes_150_d_un_panier_avec_2_bananes_et_1_chocolat() {
            panier.ajouterArticle(banane150, 2);
            panier.ajouterArticle(chocolat, 1);

            panier.supprimerArticle(banane150, 2);

            assertThat(panier.getNombreArticles()).isEqualTo(1);
            assertThat(panier.getMontantTotal()).isCloseTo(10.0, within(PRECISION));
        }
    }

    @Nested
    class ViderPanier {
        @Test
        void cycle1_vider_un_panier_vide() {
            panier.viderPanier();

            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }

        @Test
        void cycle2_vider_un_panier_avec_1_banane_et_2_chocolats() {
            panier.ajouterArticle(banane150, 1);
            panier.ajouterArticle(chocolat, 2);

            panier.viderPanier();

            assertThat(panier.estVide()).isTrue();
            assertThat(panier.getMontantTotal()).isCloseTo(0.0, within(PRECISION));
        }
    }
}
