package com.jarlin.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/*
 * 1.a) Scénarios (liste minimale et ordonnée) :
 *   FizzBuzz.de(1)  -> "1"
 *   FizzBuzz.de(2)  -> "2"
 *   FizzBuzz.de(3)  -> "Fizz"
 *   FizzBuzz.de(5)  -> "Buzz"
 *   FizzBuzz.de(6)  -> "Fizz"
 *   FizzBuzz.de(10) -> "Buzz"
 *   FizzBuzz.de(15) -> "FizzBuzz"
 *
 * 1.b) Justification de l'ordre : on part du cas le plus simple (constante "1") puis on généralise
 *   (de(2) force la conversion du nombre), on introduit ensuite une règle à la fois (3, puis 5) et on
 *   généralise chaque règle à ses multiples (6, 10) avant de les combiner (15) : un seul changement par cycle.
 *
 * Cycles (commits) :
 *   cycle 1 : de(1)  -> "1"        : return "1";
 *   cycle 2 : de(2)  -> "2"        : return String.valueOf(nbre);
 *   cycle 3 : de(3)  -> "Fizz"     : if (nbre == 3) return "Fizz";
 *   cycle 4 : de(5)  -> "Buzz"     : if (nbre == 5) return "Buzz";
 *   cycle 5 : de(6)  -> "Fizz"     : nbre == 3  -> nbre % 3 == 0
 *   cycle 6 : de(10) -> "Buzz"     : nbre == 5  -> nbre % 5 == 0
 *   cycle 7 : de(15) -> "FizzBuzz" : if (nbre % 15 == 0) return "FizzBuzz"; (placé en premier)
 *   refactor cycle 7 : concaténation de "Fizz" et "Buzz" -> plus de test % 15 redondant
 */
public class FizzBuzzTest {

    @Test
    void fizzBuzz_de_1_devrait_retourner_1() {
        assertThat(FizzBuzz.de(1)).isEqualTo("1");
    }

    @Test
    void fizzBuzz_de_2_devrait_retourner_2() {
        assertThat(FizzBuzz.de(2)).isEqualTo("2");
    }

    @Test
    void fizzBuzz_de_3_devrait_retourner_Fizz() {
        assertThat(FizzBuzz.de(3)).isEqualTo("Fizz");
    }

    @Test
    void fizzBuzz_de_5_devrait_retourner_Buzz() {
        assertThat(FizzBuzz.de(5)).isEqualTo("Buzz");
    }

    @Test
    void fizzBuzz_de_6_devrait_retourner_Fizz() {
        assertThat(FizzBuzz.de(6)).isEqualTo("Fizz");
    }

    @Test
    void fizzBuzz_de_10_devrait_retourner_Buzz() {
        assertThat(FizzBuzz.de(10)).isEqualTo("Buzz");
    }

    @Test
    void fizzBuzz_de_15_devrait_retourner_FizzBuzz() {
        assertThat(FizzBuzz.de(15)).isEqualTo("FizzBuzz");
    }

    // 3. Test paramétré de 1 à 20 (cf. Tableau 1)
    @ParameterizedTest(name = "FizzBuzz.de({0}) -> {1}")
    @CsvSource({
            "1, 1", "2, 2", "3, Fizz", "4, 4", "5, Buzz", "6, Fizz", "7, 7", "8, 8", "9, Fizz", "10, Buzz",
            "11, 11", "12, Fizz", "13, 13", "14, 14", "15, FizzBuzz", "16, 16", "17, 17", "18, Fizz", "19, 19", "20, Buzz"
    })
    void fizzBuzz_de_1_a_20(int nombre, String attendu) {
        assertThat(FizzBuzz.de(nombre)).isEqualTo(attendu);
    }
}
