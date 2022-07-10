package pl.piekoszek.image;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ImageServiceTest {

    @Test
    void shouldChangePixelsToBlackAndWhite() throws IOException {
        var imageConverter = new BufferedImageConverter();
        var imageService = new ImageService(imageConverter);

        var image = new BufferedImage(2,2, BufferedImage.TYPE_INT_RGB);

        image.setRGB(0, 0, new Color(50, 100, 150).getRGB());
        image.setRGB(0, 1, new Color(145, 57, 173).getRGB());
        image.setRGB(1, 0, new Color(120, 149, 178).getRGB());
        image.setRGB(1, 1, new Color(169, 155, 101).getRGB());

        var blackAndWhiteImage = imageConverter.toBufferedImage(
                imageService.toBlackAndWhite(imageConverter.toByteArray(image)));

        assertColor(new Color(blackAndWhiteImage.getRGB(0,0)), 100);
        assertColor(new Color(blackAndWhiteImage.getRGB(0,1)), 125);
        assertColor(new Color(blackAndWhiteImage.getRGB(1,0)), 149);
        assertColor(new Color(blackAndWhiteImage.getRGB(1,1)), 141);


    }

    private void assertColor(Color color, int expectedColor) {
        assertThat(color.getRed())
                .isEqualTo(color.getGreen())
                .isEqualTo(color.getBlue())
                .isEqualTo(expectedColor);
    }
}