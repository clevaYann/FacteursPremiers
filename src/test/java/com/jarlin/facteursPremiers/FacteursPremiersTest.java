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
public class FacteursPremiersTest {

    @Test
    void generate_de_1_devrait_retourner_une_liste_vide() {
        assertThat(FacteursPremiers.generate(1)).isEmpty();
    }

    @Test
    void generate_de_2_devrait_retourner_2() {
        assertThat(FacteursPremiers.generate(2)).containsExactly(2);
    }

    @Test
    void generate_de_3_devrait_retourner_3() {
        assertThat(FacteursPremiers.generate(3)).containsExactly(3);
    }

    @Test
    void generate_de_4_devrait_retourner_2_2() {
        assertThat(FacteursPremiers.generate(4)).containsExactly(2, 2);
    }

    @Test
    void generate_de_6_devrait_retourner_2_3() {
        assertThat(FacteursPremiers.generate(6)).containsExactly(2, 3);
    }

    @Test
    void generate_de_8_devrait_retourner_2_2_2() {
        assertThat(FacteursPremiers.generate(8)).containsExactly(2, 2, 2);
    }

    @Test
    void generate_de_9_devrait_retourner_3_3() {
        assertThat(FacteursPremiers.generate(9)).containsExactly(3, 3);
    }

    @Test
    void generate_cas_general_devrait_retourner_tous_les_facteurs_dans_l_ordre() {
        assertThat(FacteursPremiers.generate(2 * 2 * 3 * 3 * 5 * 7 * 11 * 11))
                .containsExactly(2, 2, 3, 3, 5, 7, 11, 11);
    }
}
