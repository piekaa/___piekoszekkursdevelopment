///hide

package pl.piekoszek.citytemp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.fail;

class PiekoszekCheckPortTest {

    @Test
    void testPort() {
        try {
            new ServerSocket(8080);
        } catch (IOException e) {
            fail("Przed sprawdzeniem rozwiązania zatrzymaj aplikację czerwonym kwadracikiem");
        }
    }

}
