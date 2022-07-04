///hide

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(PiekoszekExtension.class)
class PiekoszekWriterTest {

    @Mock
    Letters letters;

    @Test
    void shouldUseLetters() {
        Writer writer = new Writer(letters);
        writer.connectAndCapitalizeWords("aaa", "bbb");
        verify(letters, atLeast(1).description("Musisz użyć metody capitalize na obiekcie letters")).capitalize(any());
    }

    @Test
    void shouldUseLettersForBothWords() {
        Writer writer = new Writer(letters);
        writer.connectAndCapitalizeWords("aaa", "bbb");
        verify(letters, description("Musisz użyć metody capitalize na obiekcie letters dla pierwszego słowa dokładnie jeden raz")).capitalize("aaa");
        verify(letters, description("Musisz użyć metody capitalize na obiekcie letters dla drugiego słowa dokładnie jeden raz")).capitalize("bbb");
    }

    @Test
    void shouldConnectWords() {
        Writer writer = new Writer(letters);

        when(letters.capitalize("marian")).thenReturn("Marian");
        when(letters.capitalize("pazdzioch")).thenReturn("Pazdzioch");

        var result = writer.connectAndCapitalizeWords("marian", "pazdzioch");

        assertThat(result)
                .withFailMessage("""
                        dla "marian", "pazdzioch", powinno być "MarianPazdzioch", a nie "%s" """.formatted(result))
                .isEqualTo("MarianPazdzioch");
    }
}