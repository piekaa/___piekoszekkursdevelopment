///hide

package pl.piekoszek.image;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekImageServiceTest {

    @Test
    void shouldChangePixelsToBlackAndWhite() throws IOException {
        var imageConverter = new BufferedImageConverter();
        var imageService = new ImageService(imageConverter);

        var image = new BufferedImage(2,2, BufferedImage.TYPE_INT_RGB);

        image.setRGB(0, 0, new Color(1, 2, 3).getRGB());
        image.setRGB(0, 1, new Color(4, 5, 6).getRGB());
        image.setRGB(1, 0, new Color(8, 9, 10).getRGB());
        image.setRGB(1, 1, new Color(30, 20, 40).getRGB());

        var blackAndWhiteImage = imageConverter.toBufferedImage(
                imageService.toBlackAndWhite(imageConverter.toByteArray(image)));

        assertColor(new Color(blackAndWhiteImage.getRGB(0,0)), 2);
        assertColor(new Color(blackAndWhiteImage.getRGB(0,1)), 5);
        assertColor(new Color(blackAndWhiteImage.getRGB(1,0)), 9);
        assertColor(new Color(blackAndWhiteImage.getRGB(1,1)), 20);


    }

    private void assertColor(Color color, int expectedColor) {
        assertThat(color.getRed())
                .withFailMessage("Czerwony nie jest taki sam, jak zielony")
                .isEqualTo(color.getGreen())
                .withFailMessage("Czerwony nie jest taki sam, jak niebieski")
                .isEqualTo(color.getBlue())
                .withFailMessage("Kolor nie jest średnią składowych")
                .isEqualTo(expectedColor);
    }
}