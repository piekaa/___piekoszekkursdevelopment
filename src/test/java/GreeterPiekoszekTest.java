///hide
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
public class GreeterPiekoszekTest {

    @Test
    void shouldGreet() {
        Greeter greeter = new Greeter();
        String forPiotr = greeter.greet("Piotr");
        assertThat(forPiotr)
                .withFailMessage("Piotra powinno przywitać: \"Good morning, Piotr\", a nie \"%s\"", forPiotr)
                .isEqualTo("Good morning, Piotr");

        assertThat(greeter.greet("Mark"))
                .withFailMessage("Nie działa dla innych imion?")
                .isEqualTo("Good morning, Mark");

        assertThat(greeter.greet("Zuzia"))
                .withFailMessage("Nie działa dla innych imion?")
                .isEqualTo("Good morning, Zuzia");

        assertThat(greeter.greet("DupaJasiaKleofasa"))
                .withFailMessage("Nie działa dla innych imion?")
                .isEqualTo("Good morning, DupaJasiaKleofasa");
    }

    @Test
    void shouldNotEndWithExclamationMark() {
        Greeter greeter = new Greeter();
        String greeting = greeter.greet("Piotr");
        assertThat(greeting)
                .withFailMessage("Przywitanie nie powinno kończyć się wykrzyknikiem")
                .doesNotEndWith("!");
    }

    @Test
    void shouldContainComma() {
        Greeter greeter = new Greeter();
        String greeting = greeter.greet("Piotr");
        assertThat(greeting)
                .withFailMessage("Brakuje przecinka")
                .contains(",");
    }
}
