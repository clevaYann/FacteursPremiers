package com.jarlin.romains;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/*
 * Étape 0 : Think !
 *   Plus grand nombre convertible (7 lettres, au plus 3 répétitions) : 3999 = MMMCMXCIX
 *
 *   Scénarios (dans l'ordre d'écriture des tests) :
 *   convert(1)  -> I       : un symbole simple
 *   convert(2)  -> II      : répétition
 *   convert(3)  -> III     : répétition maximale (3 fois)
 *   convert(4)  -> IV      : soustraction
 *   convert(5)  -> V       : nouveau symbole
 *   convert(6)  -> VI      : addition à droite
 *   convert(9)  -> IX      : soustraction devant X
 *   convert(10) -> X
 *   convert(14) -> XIV     : combinaison addition + soustraction
 *   convert(39) -> XXXIX
 *   convert(40) -> XL
 *   convert(49) -> XLIX
 *   convert(50) -> L       : borne max demandée
 */
class ArabicRomanNumeralsTest {

    @Test
    void devrait_retourner_I_pour_1() {
        // GIVEN
        var nombre = 1;
        // WHEN
        var romain = ArabicRomanNumerals.convert(nombre);
        // THEN
        assertThat(romain).isEqualTo("I");
    }

    @Test
    void devrait_retourner_III_pour_3() {
        // GIVEN
        var nombre = 3;
        // WHEN
        var romain = ArabicRomanNumerals.convert(nombre);
        // THEN
        assertThat(romain).isEqualTo("III");
    }

    @Test
    void devrait_retourner_IV_pour_4() {
        // GIVEN
        var nombre = 4;
        // WHEN
        var romain = ArabicRomanNumerals.convert(nombre);
        // THEN
        assertThat(romain).isEqualTo("IV");
    }

    @Test
    void devrait_retourner_X_pour_10() {
        // GIVEN
        var nombre = 10;
        // WHEN
        var romain = ArabicRomanNumerals.convert(nombre);
        // THEN
        assertThat(romain).isEqualTo("X");
    }

    @Test
    void devrait_retourner_XXXIX_pour_39() {
        // GIVEN
        var nombre = 39;
        // WHEN
        var romain = ArabicRomanNumerals.convert(nombre);
        // THEN
        assertThat(romain).isEqualTo("XXXIX");
    }

    @ParameterizedTest(name = "convert({0}) -> {1}")
    @CsvSource({
            "1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX",
            "10, X", "14, XIV", "19, XIX", "20, XX", "39, XXXIX", "40, XL", "44, XLIV",
            "49, XLIX", "50, L", "1970, MCMLXX", "2025, MMXXV", "3999, MMMCMXCIX"
    })
    void devrait_retourner_le_nombre_en_chiffres_romains(int nombre, String attendu) {
        // GIVEN (nombre et attendu fournis par @CsvSource)
        // WHEN
        var romain = ArabicRomanNumerals.convert(nombre);
        // THEN
        assertThat(romain).isEqualTo(attendu);
    }
}
