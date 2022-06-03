///hide
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
public class GreeterPiekoszekTest {

    @Test
    void shouldGreet() {
        assertThat(new Greeter().greet())
                .withFailMessage("Powinno zwrócić \"Good morning!\"")
                .isEqualTo("Good morning!");
    }

}
