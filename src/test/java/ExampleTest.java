import extension.PiekoszekExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
public class ExampleTest {

    @Test
    void test() {
        assertThat(new Main().metoda()).withFailMessage("Panie, 10 ma być").isEqualTo(10);
    }

    @Test
    @Disabled
    void tenNiePrzejdzie() {
        throw new RuntimeException();
//        assertThat(new Main().metoda()).withFailMessage("rododendron").isEqualTo(12);
    }

    @Test
    void tenNiePrzejdzie2() {
        assertThat(new Main().metoda()).withFailMessage("/api/dupa zwróciło 500 przy dodawaniu").isEqualTo(123);
    }
}
