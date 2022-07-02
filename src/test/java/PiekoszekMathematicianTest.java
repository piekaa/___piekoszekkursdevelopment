///hide

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PiekoszekMathematicianTest {

    Mathematician mathematician = new Mathematician();

    @Test
    void testOrder() {
        assertThat(mathematician.specialEquation(2, 2, 2, 2))
                .withFailMessage("Zwróć uwagnę na kolejność wykonywania działań, najpierw to, co w nawiasie")
                .isEqualTo(4f, Offset.offset(0.05f));
    }

    @Test
    void testSpecificEquation() {
        var result = mathematician.specialEquation(34, 0.43f, 0.123f, 0.41f);
        assertThat(result)
                .withFailMessage("""
                                         (34 +0.43) * 0.123 / 0.41 = 10.329, a nie 
                                         """ + result)
                .isEqualTo(10.329f, Offset.offset(0.05f));
    }

    @Test
    void testRandomStuff() {
        var result = mathematician.specialEquation(43, 12, 99, 231);
        assertThat(result)
                .withFailMessage("Coś nie tak, próbuj dalej")
                .isEqualTo(23.571428f, Offset.offset(0.05f));
    }
}