import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PiekoszekWriterTest {

    @Mock
    private Letters letters;

    @Test
    void shouldUseLetters() {
        Writer writer = new Writer(letters);
        writer.connectAndCapitalizeWords("aaa", "bbb");
        verify(letters, description("Musisz użyć metody capitalize na obiekcie letters")).capitalize(any());
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

        var result = writer.connectAndCapitalizeWords("aaa", "bbb");

        assertThat(result)
                .withFailMessage("""
                        dla "marian", "pazdzioch", powinno być "MarianPazdzioch", a nie "%s" """.formatted(result))
                .isEqualTo("AaaBbb");
    }
}