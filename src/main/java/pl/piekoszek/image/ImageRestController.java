package pl.piekoszek.image;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api")
class ImageRestController {

    private final ImageService imageService;

    ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "black-and-white", produces = MediaType.IMAGE_PNG_VALUE)
    byte[] toBlackAndWhite(@RequestBody byte[] imageBytes) throws IOException {
        return imageService.toBlackAndWhite(imageBytes);
    }
}
