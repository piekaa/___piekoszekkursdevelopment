import extension.PiekoszekExtension;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
public class PiekoszekCalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertThat(calculator.add(123, 321))
                .withFailMessage("Dodawanie nie działa")
                .isEqualTo(444);

        assertThat(calculator.add(10, -20))
                .withFailMessage("Dodawanie - sprawdź ujemne liczby")
                .isEqualTo(-10);

    }

    @Test
    void testSubtract() {
        assertThat(calculator.subtract(123, 100))
                .withFailMessage("Odejmowanie nie działa")
                .isEqualTo(23);

        assertThat(calculator.subtract(10, -20))
                .withFailMessage("Odejmowanie - sprawdź ujemne liczby")
                .isEqualTo(30);
    }

    @Test
    void testSquare() {
        assertThat(calculator.square(16))
                .withFailMessage("Podniesienie do kwadratu nie działa")
                .isEqualTo(256);
    }

    @Test
    void testMultiply() {
        assertThat(calculator.multiply(10, 60))
                .withFailMessage("Mnożenie nie działa")
                .isEqualTo(600);
    }

    @Test
    void testDivide() {
        assertThat(calculator.divide(10, 60))
                .withFailMessage("Dzielenie nie działa")
                .isEqualTo(0.16f, Offset.offset(0.1f));
    }

    @Test
    void testModulo() {
        assertThat(calculator.modulo(13, 3))
                .withFailMessage("Reszta z dzielenia nie działa")
                .isEqualTo(1);
    }
}
