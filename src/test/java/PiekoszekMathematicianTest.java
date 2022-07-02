///hide

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PiekoszekMathematicianTest {

    Mathematician mathematician = new Mathematician();

    @Test
    void shouldBeOdd() {
        for (var number : List.of(-5, 11, 23423, 555555, 100001, 3225777, 1382147)) {
            var result = mathematician.oddOrEven(number);
            checkAllowed(result);
            assertThat(result)
                    .withFailMessage("%s to liczba nieparzysta".formatted(number))
                    .isEqualTo("odd");
        }
    }

    @Test
    void shouldBeEven() {
        for (var number : List.of(0, 2, 6, 20, 5432, 4388, 1030210)) {
            var result = mathematician.oddOrEven(number);
            checkAllowed(result);
            assertThat(result)
                    .withFailMessage("%s to liczba parzysta".formatted(number))
                    .isEqualTo("even");
        }
    }

    private void checkAllowed(String result) {
        assertThat(result).withFailMessage("Wynik nie może być nullem").isNotNull();
        assertThat(List.of("odd", "even").contains(result)).withFailMessage("""
                Powinno być "prime" lub "odd", a nie "%s" """.formatted(result)).isTrue();

    }

}