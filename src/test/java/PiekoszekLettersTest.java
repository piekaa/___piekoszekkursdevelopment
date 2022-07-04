///hide

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekLettersTest {

    Letters letters = new Letters();

    @Test
    void test() {
        assertThat(letters.next('a'))
                .withFailMessage("a ma zmienić na b")
                .isEqualTo('b');

        assertThat(letters.next('G'))
                .withFailMessage("Nie działa dla wielkich liter?")
                .isEqualTo('H');

        assertThat(letters.next('z'))
                .withFailMessage("Dla z ma być a")
                .isEqualTo('a');

        assertThat(letters.next('Z'))
                .withFailMessage("Dla Z ma być A")
                .isEqualTo('A');

        assertThat(letters.next('x'))
                .withFailMessage("Coś nie tak...")
                .isEqualTo('y');
    }

}