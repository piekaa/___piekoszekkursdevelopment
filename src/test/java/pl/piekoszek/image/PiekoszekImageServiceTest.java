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

        var image = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);

        image.setRGB(0, 0, new Color(1, 2, 3).getRGB());
        image.setRGB(0, 1, new Color(4, 5, 6).getRGB());
        image.setRGB(1, 0, new Color(8, 9, 10).getRGB());
        image.setRGB(1, 1, new Color(30, 20, 40).getRGB());

        var reverseImage = imageConverter.toBufferedImage(
                imageService.reverseColors(imageConverter.toByteArray(image)));

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
                .withFailMessage("Czerwona sładowa jednego z kolorów różni się o %d od poprawnej wartości".formatted(diffR))
                .isEqualTo(0);

        assertThat(diffG)
                .withFailMessage("Zielona sładowa jednego z kolorów różni się o %d od poprawnej wartości".formatted(diffG))
                .isEqualTo(0);

        assertThat(diffB)
                .withFailMessage("Niebieska sładowa jednego z kolorów różni się o %d od poprawnej wartości".formatted(diffB))
                .isEqualTo(0);

    }
}