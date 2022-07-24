///hide

package pl.piekoszek.citytemp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(PiekoszekExtension.class)
class PiekoszekHottestCityTest {

    @Autowired
    private MockMvc mockMvc;

    @Configuration
    static class FakePiekoszekCityTempController {

        @Bean
        @Primary
        public PiekoszekCityTempService getPiekoszekCityTempService() {
            return new PiekoszekCityTempService() {
                @Override
                List<PiekoszekCityTemp> getAll() {
                    return List.of(
                            new PiekoszekCityTemp("New York", 50),
                            new PiekoszekCityTemp("Kotlin", 50.5f),
                            new PiekoszekCityTemp("Zandberg", 13)
                    );
                }
            };
        }

    }

    @Test
    void testEndpoint() throws Exception {
        var response = mockMvc.perform(get("/api/hottest-city"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .withFailMessage("Nie ma endpointu /api/hottest-city?")
                .isNotEqualTo(404);

        assertThat(response.getStatus())
                .withFailMessage("Endpoint /api/hottest-city nie obsługuje metody GET?")
                .isNotEqualTo(405);

        assertThat(response.getStatus())
                .withFailMessage("Endpoint nie zwrócił kodu odpowiedzi 200")
                .isEqualTo(200);

        try {
            var json = new ObjectMapper().readValue(response.getContentAsByteArray(), PiekoszekCityTemp.class);

            assertThat(json.city)
                    .withFailMessage("Pole city w odpowiedzi jest puste")
                    .isNotEmpty();

            assertThat(json.city)
                    .withFailMessage("Zwrócono złe miasto")
                    .isEqualTo("Kotlin");

        } catch (Exception e) {
            fail("Nie udało się odczytać odpowiedzi, czy jest to JSON i zawiera odpowiednie pole?");
        }
    }
}
