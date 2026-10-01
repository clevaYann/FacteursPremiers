package com.jarlin.personnage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/*
 * Étape 0 : Think ! — scénarios (personnage initialement orienté au NORD)
 *   nouveau personnage            -> NORD
 *   tourner(1)                    -> EST
 *   tourner(2)                    -> SUD
 *   tourner(3)                    -> OUEST
 *   tourner(4)                    -> NORD   (un tour complet)
 *   tourner(5)                    -> EST    (plus d'un tour)
 *   tourner(0)                    -> NORD   (pas de rotation)
 *   tourner(1) puis tourner(1)    -> SUD    (rotations cumulées)
 *   tourner(-1)                   -> OUEST  (sens inverse)
 */
class PersonnageTest {

    @Test
    void devrait_etre_oriente_au_nord_a_sa_creation() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.getOrientation();
        // THEN
        assertThat(orientation).isEqualTo(Orientation.NORD);
    }

    @Test
    void devrait_etre_oriente_a_l_est_apres_1_quart_de_tour() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(1);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.EST);
    }

    @Test
    void devrait_etre_oriente_au_sud_apres_2_quarts_de_tour() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(2);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.SUD);
    }

    @Test
    void devrait_etre_oriente_a_l_ouest_apres_3_quarts_de_tour() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(3);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.OUEST);
    }

    @Test
    void devrait_etre_oriente_au_nord_apres_un_tour_complet() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(4);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.NORD);
    }

    @Test
    void devrait_etre_oriente_a_l_est_apres_5_quarts_de_tour() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(5);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.EST);
    }

    @Test
    void devrait_rester_oriente_au_nord_sans_rotation() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(0);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.NORD);
    }

    @Test
    void devrait_cumuler_les_rotations_successives() {
        // GIVEN
        var personnage = new Personnage();
        personnage.tourner(1);
        // WHEN
        var orientation = personnage.tourner(1);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.SUD);
        assertThat(personnage.getOrientation()).isEqualTo(Orientation.SUD);
    }

    @Test
    void devrait_etre_oriente_a_l_ouest_apres_1_quart_de_tour_en_sens_inverse() {
        // GIVEN
        var personnage = new Personnage();
        // WHEN
        var orientation = personnage.tourner(-1);
        // THEN
        assertThat(orientation).isEqualTo(Orientation.OUEST);
    }
}
