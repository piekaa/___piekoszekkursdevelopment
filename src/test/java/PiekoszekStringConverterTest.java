///hide

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PiekoszekStringConverterTest {

    private StringConverter stringConverter = new StringConverter();

    @Test
    void testFirstLetter() {
        var result = stringConverter.toPascalCase("daj mnie nogie");
        assertThat(result)
                .withFailMessage("Nie zamienia pierwszej litery w tekście na wielką")
                .isNotEqualTo("dajMnieNogie");
    }

    @Test
    void testRandomStuff() {
        var result = stringConverter.toPascalCase("było cymbalistwó wielu");
        assertThat(result)
                .withFailMessage("""
                        Dla "było cymbalistów wielu" powinno być "ByłoCymbalistówWielu", a nie "%s" """.formatted(result));

        assertThat(stringConverter.toPascalCase("dupa jasia kleofasa"))
                .withFailMessage("Coś nie działa")
                .isEqualTo("DupaJasiaKleofasa");
    }
}
