///hide

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekTextDrawerTest {

    private TextDrawer textDrawer = new TextDrawer();

    @Test
    void testSquareHasSpaces() {
        assertThat(textDrawer.drawSquare(2))
                .withFailMessage("Brakuje przejścia do nowej linii")
                .isNotEqualTo("####");
    }

    @Test
    void assertSupportedCharacters() {
        assertThat(textDrawer.drawSquare(4).lines())
                .withFailMessage("Tekst zawiera znak inny niż #")
                .allMatch(line -> line.chars().allMatch(c -> c == '#'));
    }

    @Test
    void assertCorrectDrawing() {
        assertThat(textDrawer.drawSquare(6))
                .withFailMessage("String nie powinien kończyć się przejściem do nowej linii")
                .isNotEqualTo("######\n######\n######\n######\n######\n######\n");

        assertThat(textDrawer.drawSquare(6))
                .withFailMessage("Coś nie tak rysuje")
                .isEqualTo("######\n######\n######\n######\n######\n######");
    }


}