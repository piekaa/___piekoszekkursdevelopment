import extension.PiekoszekExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
public class AnotherExampleTest {

    @Test
    @Disabled
    void fjsaiofaj() {
        assertThat(new Main().metoda()).isEqualTo(10);
    }

    @Test
    void fsojfoai() {
        assertThat(new Main().metoda()).withFailMessage("Toż mówiłem, że dziesięć").isEqualTo(10);
    }

    @Test
    void iuoihuip() {
        assertThat(new Main().metoda()).withFailMessage("Zwróc uwagę na liczby ujemne").isEqualTo(10);
    }
}
