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
public class ArabicRomanNumeralsTest {

    @Test
    void convert_de_1_devrait_retourner_I() {
        assertThat(ArabicRomanNumerals.convert(1)).isEqualTo("I");
    }

    @Test
    void convert_de_3_devrait_retourner_III() {
        assertThat(ArabicRomanNumerals.convert(3)).isEqualTo("III");
    }

    @Test
    void convert_de_4_devrait_retourner_IV() {
        assertThat(ArabicRomanNumerals.convert(4)).isEqualTo("IV");
    }

    @Test
    void convert_de_10_devrait_retourner_X() {
        assertThat(ArabicRomanNumerals.convert(10)).isEqualTo("X");
    }

    @Test
    void convert_de_39_devrait_retourner_XXXIX() {
        assertThat(ArabicRomanNumerals.convert(39)).isEqualTo("XXXIX");
    }

    @ParameterizedTest(name = "convert({0}) -> {1}")
    @CsvSource({
            "1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX",
            "10, X", "14, XIV", "19, XIX", "20, XX", "39, XXXIX", "40, XL", "44, XLIV",
            "49, XLIX", "50, L", "1970, MCMLXX", "2025, MMXXV", "3999, MMMCMXCIX"
    })
    void convert_devrait_retourner_le_nombre_en_chiffres_romains(int nombre, String attendu) {
        assertThat(ArabicRomanNumerals.convert(nombre)).isEqualTo(attendu);
    }
}
