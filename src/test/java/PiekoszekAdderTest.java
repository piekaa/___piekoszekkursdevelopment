///hide

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PiekoszekAdderTest {

    Adder adder = new Adder();

    @Test
    void test() {

        var result = adder.add(new int[]{100, 200, 300, 400});
        assertThat(result)
                .withFailMessage("Pomyliłeś/aś parzyste z nieparzystymi")
                .isNotEqualTo(new SumResult(400, 600));

        result = adder.add(new int[]{10, 20, 50, 60});
        assertThat(result)
                .withFailMessage("Dla [10, 20, 50, 60] powinno być (80, 60), a nie %s".formatted(result))
                .isEqualTo(new SumResult(80, 60));

        assertThat(new int[]{4236, 13, 345, 122, 321, 56})
                .withFailMessage("Coś nie działa")
                .isEqualTo(new SumResult(191, 4902));
    }

}