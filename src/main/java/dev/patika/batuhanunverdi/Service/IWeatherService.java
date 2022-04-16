package dev.patika.batuhanunverdi.Service;

import dev.patika.batuhanunverdi.Model.WeatherModel;
import org.springframework.http.ResponseEntity;

/**
 * @author Mert Batuhan UNVERDI
 * @since 14.04.2022
 */
public interface IWeatherService {
    ResponseEntity<String> getCurrentWeatherByCity(String name);
}
