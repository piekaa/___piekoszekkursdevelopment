///hide

package pl.piekoszek.citytemp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
properties = "server.port=8080")
@ExtendWith(PiekoszekExtension.class)
class PiekoszekHottestCityTest {

    @LocalServerPort
    private int serverPort;

    @MockBean
    PiekoszekCityTempService piekoszekCityTempService;


    @Test
    void testEndpoint() throws Exception {

        when(piekoszekCityTempService.getAll())
                .thenReturn(List.of(
                        new PiekoszekCityTemp("New York", 50),
                        new PiekoszekCityTemp("Kotlin", 50.5f),
                        new PiekoszekCityTemp("Zandberg", 13)));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PiekoszekCityTemp> response = null;
        try {
            response = restTemplate.getForEntity("http://localhost:" + serverPort + "/api/hottest-city", PiekoszekCityTemp.class);
        } catch (
                Exception e) {
            fail("Nie udało się odczytać odpowiedzi, czy jest to JSON i zawiera odpowiednie pole?");
        }

        assertThat(response.getStatusCodeValue())
                .withFailMessage("Nie ma endpointu /api/hottest-city?")
                .isNotEqualTo(404);

        assertThat(response.getStatusCodeValue())
                .withFailMessage("Endpoint /api/hottest-city nie obsługuje metody GET?")
                .isNotEqualTo(405);

        assertThat(response.getStatusCodeValue())
                .withFailMessage("Endpoint nie zwrócił kodu odpowiedzi 200")
                .isEqualTo(200);

        assertThat(response.getBody().city)
                .withFailMessage("Pole city w odpowiedzi jest puste")
                .isNotEmpty();

        assertThat(response.getBody().city)
                .withFailMessage("Zwrócono złe miasto")
                .isEqualTo("Kotlin");
    }
}
