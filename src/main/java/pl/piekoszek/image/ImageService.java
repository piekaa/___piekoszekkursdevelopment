package pl.piekoszek.image;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class ImageService {

    private final BufferedImageConverter bufferedImageConverter;

    ImageService(BufferedImageConverter bufferedImageConverter) {
        this.bufferedImageConverter = bufferedImageConverter;
    }

    byte[] toBlackAndWhite(byte[] imageBytes) throws IOException {
        return imageBytes;
    }
}
