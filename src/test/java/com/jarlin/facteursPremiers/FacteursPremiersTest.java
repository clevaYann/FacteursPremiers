package com.jarlin.facteursPremiers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/*
 * Étape 0 : Think ! — scénarios représentatifs (dans l'ordre d'écriture des tests)
 *   generate(1) -> {}         : 1 n'a pas de diviseur premier
 *   generate(2) -> {2}        : un nombre premier
 *   generate(3) -> {3}        : un autre nombre premier
 *   generate(4) -> {2, 2}     : un facteur répété
 *   generate(6) -> {2, 3}     : deux facteurs différents
 *   generate(8) -> {2, 2, 2}  : un facteur répété plus de deux fois
 *   generate(9) -> {3, 3}     : un facteur répété autre que 2
 *   generate(2*2*3*3*5*7*11*11) -> {2, 2, 3, 3, 5, 7, 11, 11} : cas général
 */
class FacteursPremiersTest {

    @Test
    void devrait_retourner_une_liste_vide_pour_1() {
        // GIVEN
        var nombre = 1;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).isEmpty();
    }

    @Test
    void devrait_retourner_2_pour_2() {
        // GIVEN
        var nombre = 2;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(2);
    }

    @Test
    void devrait_retourner_3_pour_3() {
        // GIVEN
        var nombre = 3;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(3);
    }

    @Test
    void devrait_retourner_2_2_pour_4() {
        // GIVEN
        var nombre = 4;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(2, 2);
    }

    @Test
    void devrait_retourner_2_3_pour_6() {
        // GIVEN
        var nombre = 6;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(2, 3);
    }

    @Test
    void devrait_retourner_2_2_2_pour_8() {
        // GIVEN
        var nombre = 8;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(2, 2, 2);
    }

    @Test
    void devrait_retourner_3_3_pour_9() {
        // GIVEN
        var nombre = 9;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(3, 3);
    }

    @Test
    void devrait_retourner_tous_les_facteurs_dans_l_ordre_pour_un_cas_general() {
        // GIVEN
        var nombre = 2 * 2 * 3 * 3 * 5 * 7 * 11 * 11;
        // WHEN
        var facteurs = FacteursPremiers.generate(nombre);
        // THEN
        assertThat(facteurs).containsExactly(2, 2, 3, 3, 5, 7, 11, 11);
    }
}
