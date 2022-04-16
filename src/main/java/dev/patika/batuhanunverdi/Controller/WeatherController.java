package dev.patika.batuhanunverdi.Controller;


import dev.patika.batuhanunverdi.Service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author Mert Batuhan UNVERDI
 * @since 12.04.2022
 */

@RestController
@RequestMapping(path = "/api")
@Validated
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping(path = "/weathers/{cityName}")
    public ResponseEntity<String> getCurrentWeatherByCity(@PathVariable
                                                                    @Valid
                                                                    @NotBlank (message = "City name can not be blank")
                                                                    String cityName)
    {
        return service.getCurrentWeatherByCity(cityName);
    }
}