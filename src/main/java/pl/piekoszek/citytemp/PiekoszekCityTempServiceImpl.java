///hide

package pl.piekoszek.citytemp;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
class PiekoszekCityTempServiceImpl implements PiekoszekCityTempService{

    public List<PiekoszekCityTemp> getAll() {
        return List.of(
                new PiekoszekCityTemp("Supraśl", 10.3f),
                new PiekoszekCityTemp("Białystok", -15.1f),
                new PiekoszekCityTemp("Warszawa", 50.7f),
                new PiekoszekCityTemp("Krynki", 10.2f)
        );
    }
}
