///hide

package pl.piekoszek.citytemp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class PiekoszekCityTempController {

    private final PiekoszekCityTempService piekoszekCityTempService;

    PiekoszekCityTempController(PiekoszekCityTempService piekoszekCityTempService) {
        this.piekoszekCityTempService = piekoszekCityTempService;
    }

    @GetMapping("api/temperature/cities")
    List<PiekoszekCityTemp> getCityTemps() {
        return piekoszekCityTempService.getAll();
    }

}
