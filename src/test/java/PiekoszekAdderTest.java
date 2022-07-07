///hide

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PiekoszekAdderTest {

    Adder adder = new Adder();

    @Test
    void shouldAdd() {
        var result = adder.add(new int[]{320, 123, 455});
        assertThat(result)
                .withFailMessage("Dla [320, 123, 455] powinno być 898, a nie %d".formatted(result))
                .isEqualTo(898);

        assertThat(adder.add(new int[]{1, 1, 1, 1, -1, -1, -1, 1}))
                .withFailMessage("Nie działa dla ujemnych elementów tablicy?")
                .isEqualTo(2);

        assertThat(adder.add(new int[]{1, 1, 1, 1, 1, 1, 1, 1}))
                .withFailMessage("Coś nie działa")
                .isEqualTo(8);

        assertThat(adder.add(new int[]{100, 100, 100}))
                .withFailMessage("Coś nie działa")
                .isEqualTo(300);
    }

}