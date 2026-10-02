import com.jarlin.facteursPremiers.FacteursPremiers;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FacteursPremiersTest {

    @Test
    public void generate_devrait_retourner_la_liste_des_nombres_premiers() {
        // GIVEN
        var n = 1; //

        // WHEN
        var facteurs_premiers = FacteursPremiers.generate(n);

        // THEN
        var attendu = List.of(2, 3);
        assertEquals(attendu, facteurs_premiers);
    }
}