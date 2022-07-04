///hide

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PiekoszekMathematicianTest {

    private final Mathematician mathematician = new Mathematician();

    @Test
    void shouldCheckCorrectEquationWithPlus() {
        assertThat(mathematician.isEquationCorrect("2+3=5"))
                .withFailMessage("2+3=5 to poprawne równanie")
                .isTrue();

        assertThat(mathematician.isEquationCorrect("4+5=9"))
                .withFailMessage("4+5=9 to poprawne równanie")
                .isTrue();

        assertThat(mathematician.isEquationCorrect("1+7=8"))
                .withFailMessage("Coś nie tak z dodawaniem")
                .isTrue();
    }

    @Test
    void shouldCheckIncorrectEquationWithPlus() {
        assertThat(mathematician.isEquationCorrect("3+3=0"))
                .withFailMessage("3+3=0 to niepoprawne równanie")
                .isFalse();

        assertThat(mathematician.isEquationCorrect("7+1=5"))
                .withFailMessage("7+1=5 to niepoprawne równanie")
                .isFalse();

        assertThat(mathematician.isEquationCorrect("1+7=9"))
                .withFailMessage("Coś nie tak z dodawaniem")
                .isFalse();
    }

    @Test
    void shouldCheckCorrectEquationWithMinus() {
        assertThat(mathematician.isEquationCorrect("3-2=5"))
                .withFailMessage("Nie obsługujesz odejmowania?")
                .isFalse();

        assertThat(mathematician.isEquationCorrect("7-4=3"))
                .withFailMessage("7-4=3 to poprawne równanie")
                .isTrue();

        assertThat(mathematician.isEquationCorrect("9-9=0"))
                .withFailMessage("9-9=0 to poprawne równanie")
                .isTrue();

        assertThat(mathematician.isEquationCorrect("5-3=2"))
                .withFailMessage("Coś nie tak z odejmowaniem")
                .isTrue();
    }

    @Test
    void shouldCheckIncorrectEquationWithMinus() {
        assertThat(mathematician.isEquationCorrect("8-6=1"))
                .withFailMessage("8-6=1 to niepoprawne równanie")
                .isFalse();

        assertThat(mathematician.isEquationCorrect("2-2=3"))
                .withFailMessage("2-2=3 to niepoprawne równanie")
                .isFalse();

        assertThat(mathematician.isEquationCorrect("7-6=8"))
                .withFailMessage("Coś nie tak z odejmowaniem")
                .isFalse();
    }

}