package com.jarlin.somme;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/*
 * Étape 0 : Think ! — scénarios (dans l'ordre d'écriture des tests)
 *   somme("")          -> 0    : chaîne vide
 *   somme("4")         -> 4    : un seul nombre
 *   somme("1,2")       -> 3    : deux nombres
 *   somme("1,2,3,4")   -> 10   : un nombre quelconque de nombres
 *   somme("-1,5")      -> 4    : nombres négatifs
 *   somme(" 1 , 2 ")   -> 3    : espaces ignorés
 *   somme("1,a")       -> NumberFormatException : nombre invalide
 *   somme("1,2", "3")  -> 6    : VarArgs, plusieurs chaînes
 */
public class SommeChaineTest {

    @Test
    void somme_d_une_chaine_vide_devrait_retourner_0() {
        assertThat(SommeChaine.somme("")).isZero();
    }

    @Test
    void somme_de_4_devrait_retourner_4() {
        assertThat(SommeChaine.somme("4")).isEqualTo(4);
    }

    @Test
    void somme_de_1_2_devrait_retourner_3() {
        assertThat(SommeChaine.somme("1,2")).isEqualTo(3);
    }

    @Test
    void somme_de_1_2_3_4_devrait_retourner_10() {
        assertThat(SommeChaine.somme("1,2,3,4")).isEqualTo(10);
    }

    @Test
    void somme_avec_un_nombre_negatif_devrait_en_tenir_compte() {
        assertThat(SommeChaine.somme("-1,5")).isEqualTo(4);
    }

    @Test
    void somme_devrait_ignorer_les_espaces() {
        assertThat(SommeChaine.somme(" 1 , 2 ")).isEqualTo(3);
    }

    @Test
    void somme_avec_un_nombre_invalide_devrait_lever_une_exception() {
        assertThatThrownBy(() -> SommeChaine.somme("1,a")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void somme_de_plusieurs_chaines_devrait_additionner_toutes_les_chaines() {
        assertThat(SommeChaine.somme("1,2", "3")).isEqualTo(6);
    }
}
