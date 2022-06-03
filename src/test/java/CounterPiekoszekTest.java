import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class CounterPiekoszekTest {

    private Counter counter = new Counter();

    @Test
    void shouldCountTo0() {
        assertThat(counter.count(0))
                .withFailMessage("Liczenie do zera powinno zwracać pusty string - \"\"")
                .isEmpty();
    }

    @Test
    void shouldCount() {
        assertThat(counter.count(6))
                .withFailMessage("Coś nie działa, próbuj dalej")
                .isEqualTo("1 2 3 4 5 6");

        assertThat(counter.count(20))
                .withFailMessage("Coś nie działa, próbuj dalej")
                .isEqualTo("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
    }

    @Test
    void shouldBeTrimmed() {
        assertThat(counter.count(6))
                .withFailMessage("Na początku i końcu nie powinno być spacji")
                .doesNotEndWith(" ")
                .doesNotStartWith(" ");

        assertThat(counter.count(6))
                .withFailMessage("Na początku i końcu nie powinno być znaków nowej linii")
                .doesNotEndWith("\n")
                .doesNotStartWith("\n");
    }

}
