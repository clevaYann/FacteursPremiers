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
class SommeChaineTest {

    @Test
    void devrait_retourner_0_pour_une_chaine_vide() {
        // GIVEN
        var chaine = "";
        // WHEN
        var somme = SommeChaine.somme(chaine);
        // THEN
        assertThat(somme).isZero();
    }

    @Test
    void devrait_retourner_le_nombre_pour_un_seul_nombre() {
        // GIVEN
        var chaine = "4";
        // WHEN
        var somme = SommeChaine.somme(chaine);
        // THEN
        assertThat(somme).isEqualTo(4);
    }

    @Test
    void devrait_additionner_deux_nombres() {
        // GIVEN
        var chaine = "1,2";
        // WHEN
        var somme = SommeChaine.somme(chaine);
        // THEN
        assertThat(somme).isEqualTo(3);
    }

    @Test
    void devrait_additionner_un_nombre_quelconque_de_nombres() {
        // GIVEN
        var chaine = "1,2,3,4";
        // WHEN
        var somme = SommeChaine.somme(chaine);
        // THEN
        assertThat(somme).isEqualTo(10);
    }

    @Test
    void devrait_tenir_compte_des_nombres_negatifs() {
        // GIVEN
        var chaine = "-1,5";
        // WHEN
        var somme = SommeChaine.somme(chaine);
        // THEN
        assertThat(somme).isEqualTo(4);
    }

    @Test
    void devrait_ignorer_les_espaces() {
        // GIVEN
        var chaine = " 1 , 2 ";
        // WHEN
        var somme = SommeChaine.somme(chaine);
        // THEN
        assertThat(somme).isEqualTo(3);
    }

    @Test
    void devrait_lever_une_exception_pour_un_nombre_invalide() {
        // GIVEN
        var chaine = "1,a";
        // WHEN
        var exception = catchThrowable(() -> SommeChaine.somme(chaine));
        // THEN
        assertThat(exception).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void devrait_additionner_toutes_les_chaines_passees_en_parametre() {
        // GIVEN
        var premiere = "1,2";
        var seconde = "3";
        // WHEN
        var somme = SommeChaine.somme(premiere, seconde);
        // THEN
        assertThat(somme).isEqualTo(6);
    }
}
