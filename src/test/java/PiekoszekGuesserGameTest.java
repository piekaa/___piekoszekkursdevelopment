///hide

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(PiekoszekExtension.class)
@ExtendWith(MockitoExtension.class)
class PiekoszekGuesserGameTest {

    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    @Test
    void testMaxValue() {
        when(randomNumberGenerator.randomInt()).thenReturn(1000);
        var guesserGame = new GuesserGame(randomNumberGenerator, 10);

        assertThat(guesserGame.guess(1000))
                .withFailMessage("Nie uwzględniasz maksymalnej wartości")
                .isNotEqualTo(GuessResponse.CORRECT);
    }

    @Test
    void testUsedGenerator() {
        when(randomNumberGenerator.randomInt()).thenReturn(5);
        var guesserGame = new GuesserGame(randomNumberGenerator, 10);

        guesserGame.guess(1);
        guesserGame.guess(2);
        guesserGame.guess(10);
        guesserGame.guess(9);

        verify(randomNumberGenerator, description("Musisz użyć metody randomInt na obiekcie randomNumberGenerator dokładnie jeden raz")).randomInt();
    }

    @Test
    void shouldRespondWithTooLow() {
        when(randomNumberGenerator.randomInt()).thenReturn(4);
        var guesserGame = new GuesserGame(randomNumberGenerator, 10);

        var response  = guesserGame.guess(1);

        assertThat(response)
                .withFailMessage("Pokazuje że trafione, a jest za mało")
                .isNotEqualTo(GuessResponse.CORRECT);

        assertThat(response)
                .withFailMessage("Pokazuje za dużo, jak jest za mało")
                .isNotEqualTo(GuessResponse.TOO_HIGH);
    }

    @Test
    void shouldRespondWithTooHigh() {
        when(randomNumberGenerator.randomInt()).thenReturn(4);
        var guesserGame = new GuesserGame(randomNumberGenerator, 10);

        var response  = guesserGame.guess(8);

        assertThat(response)
                .withFailMessage("Pokazuje że trafione, a jest za dużo")
                .isNotEqualTo(GuessResponse.CORRECT);

        assertThat(response)
                .withFailMessage("Pokazuje za mało, jak jest za dużo")
                .isNotEqualTo(GuessResponse.TOO_LOW);
    }

    @Test
    void testModulo() {
        lenient().when(randomNumberGenerator.randomInt()).thenReturn(10);
        var guesserGame = new GuesserGame(randomNumberGenerator, 10);
        assertThat(guesserGame.guess(0))
                .withFailMessage("Wartość maksymalną należy ograniczyć za pomocą operatora modulo (%)")
                .isEqualTo(GuessResponse.CORRECT);

        lenient().when(randomNumberGenerator.randomInt()).thenReturn(11);
        guesserGame = new GuesserGame(randomNumberGenerator, 10);
        assertThat(guesserGame.guess(1))
                .withFailMessage("Wartość maksymalną należy ograniczyć za pomocą operatora modulo (%)")
                .isEqualTo(GuessResponse.CORRECT);

        lenient().when(randomNumberGenerator.randomInt()).thenReturn(12);
        guesserGame = new GuesserGame(randomNumberGenerator, 10);
        assertThat(guesserGame.guess(2))
                .withFailMessage("Wartość maksymalną należy ograniczyć za pomocą operatora modulo (%)")
                .isEqualTo(GuessResponse.CORRECT);

        lenient().when(randomNumberGenerator.randomInt()).thenReturn(13);
        guesserGame = new GuesserGame(randomNumberGenerator, 10);
        assertThat(guesserGame.guess(3))
                .withFailMessage("Wartość maksymalną należy ograniczyć za pomocą operatora modulo (%)")
                .isEqualTo(GuessResponse.CORRECT);
    }

    @Test
    void testGame() {
        when(randomNumberGenerator.randomInt()).thenReturn(6);
        var guesserGame = new GuesserGame(randomNumberGenerator, 10);
        assertThat(guesserGame.guess(0))
                .withFailMessage("Coś nie działa")
                .isEqualTo(GuessResponse.TOO_LOW);

        assertThat(guesserGame.guess(8))
                .withFailMessage("Coś nie działa")
                .isEqualTo(GuessResponse.TOO_HIGH);

        assertThat(guesserGame.guess(5))
                .withFailMessage("Coś nie działa")
                .isEqualTo(GuessResponse.TOO_LOW);

        assertThat(guesserGame.guess(6))
                .withFailMessage("Coś nie działa")
                .isEqualTo(GuessResponse.CORRECT);
    }
}