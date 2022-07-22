///hide

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekTextDrawerTest {

    private TextDrawer textDrawer = new TextDrawer();

    @Test
    void testSquareHasSpaces() {
        assertThat(textDrawer.drawRectangle(2, 2, '%'))
                .withFailMessage("Brakuje przejścia do nowej linii")
                .isNotEqualTo("%%%%");
    }

    @Test
    void assertSupportedCharacters() {
        var character = '&';
        assertThat(textDrawer.drawRectangle(2, 3, character).lines())
                .withFailMessage("Tekst zawiera inny znak, niż podany jako parametr")
                .allMatch(line -> line.chars().allMatch(c -> c == character));
    }

    @Test
    void assertCorrectDrawing() {
        assertThat(textDrawer.drawRectangle(4, 2, '&'))
                .withFailMessage("String nie powinien kończyć się przejściem do nowej linii")
                .isNotEqualTo("&&&&\n&&&&\n");

        assertThat(textDrawer.drawRectangle(4, 2, '&'))
                .withFailMessage("Coś nie tak rysuje")
                .isEqualTo("&&&&\n&&&&");
    }
}