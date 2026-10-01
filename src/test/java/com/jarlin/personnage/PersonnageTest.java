package com.jarlin.personnage;

import org.junit.jupiter.api.BeforeEach;
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
public class PersonnageTest {
    private Personnage personnage;

    @BeforeEach
    void setUp() {
        personnage = new Personnage();
    }

    @Test
    void un_nouveau_personnage_devrait_etre_oriente_au_nord() {
        assertThat(personnage.getOrientation()).isEqualTo(Orientation.NORD);
    }

    @Test
    void tourner_1_fois_devrait_retourner_est() {
        assertThat(personnage.tourner(1)).isEqualTo(Orientation.EST);
    }

    @Test
    void tourner_2_fois_devrait_retourner_sud() {
        assertThat(personnage.tourner(2)).isEqualTo(Orientation.SUD);
    }

    @Test
    void tourner_3_fois_devrait_retourner_ouest() {
        assertThat(personnage.tourner(3)).isEqualTo(Orientation.OUEST);
    }

    @Test
    void tourner_4_fois_devrait_retourner_nord() {
        assertThat(personnage.tourner(4)).isEqualTo(Orientation.NORD);
    }

    @Test
    void tourner_5_fois_devrait_retourner_est() {
        assertThat(personnage.tourner(5)).isEqualTo(Orientation.EST);
    }

    @Test
    void tourner_0_fois_devrait_retourner_nord() {
        assertThat(personnage.tourner(0)).isEqualTo(Orientation.NORD);
    }

    @Test
    void tourner_1_fois_puis_1_fois_devrait_retourner_sud() {
        personnage.tourner(1);
        assertThat(personnage.tourner(1)).isEqualTo(Orientation.SUD);
        assertThat(personnage.getOrientation()).isEqualTo(Orientation.SUD);
    }

    @Test
    void tourner_moins_1_fois_devrait_retourner_ouest() {
        assertThat(personnage.tourner(-1)).isEqualTo(Orientation.OUEST);
    }
}
