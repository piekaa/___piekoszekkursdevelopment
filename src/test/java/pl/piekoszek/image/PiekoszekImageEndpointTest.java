///hide

package pl.piekoszek.image;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(PiekoszekExtension.class)
class PiekoszekImageEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BufferedImageConverter imageConverter;

    @Test
    void testEndpoint() throws Exception {

        var image = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);

        image.setRGB(0, 0, new Color(1, 2, 3).getRGB());
        image.setRGB(0, 1, new Color(4, 5, 6).getRGB());
        image.setRGB(1, 0, new Color(8, 9, 10).getRGB());
        image.setRGB(1, 1, new Color(30, 20, 40).getRGB());

        var imageBytes = imageConverter.toByteArray(image);

        var response = mockMvc.perform(post("/api/reverse-colors")
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .content(imageBytes))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .withFailMessage("Nie ma endpointu /api/reverse-colors")
                .isNotEqualTo(404);

        assertThat(response.getStatus())
                .withFailMessage("Endpoint /api/reverse-colors nie obsługuje metody POST")
                .isNotEqualTo(405);

        assertThat(response.getStatus())
                .withFailMessage("Request do /api/reverse-colors zwrócił zły kod statusu odpowiedzi: " + response.getStatus())
                .isEqualTo(200);

        var bytes = response.getContentAsByteArray();

        var reverseImage = imageConverter.toBufferedImage(bytes);

        assertColor(new Color(reverseImage.getRGB(0, 0)), new Color(255-1, 255-2, 255-3));
        assertColor(new Color(reverseImage.getRGB(0, 1)), new Color(255-4, 255-5, 255-6));
        assertColor(new Color(reverseImage.getRGB(1, 0)), new Color(255-8, 255-9, 255-10));
        assertColor(new Color(reverseImage.getRGB(1, 1)), new Color(255-30, 255-20, 255-40));

    }

    private void assertColor(Color color, Color expectedColor) {

        var diffR = Math.abs(color.getRed() - expectedColor.getRed());
        var diffG = Math.abs(color.getGreen() - expectedColor.getGreen());
        var diffB = Math.abs(color.getBlue() - expectedColor.getBlue());

        assertThat(diffR)
                .withFailMessage("Endpoint zwraca obraz ze źle zmienionymi czerwonymi pixelami")
                .isEqualTo(0);

        assertThat(diffG)
                .withFailMessage("Endpoint zwraca obraz ze źle zmienionymi zielonymi pixelami")
                .isEqualTo(0);

        assertThat(diffB)
                .withFailMessage("Endpoint zwraca obraz ze źle zmienionymi niebieskimi pixelami")
                .isEqualTo(0);

    }

}
