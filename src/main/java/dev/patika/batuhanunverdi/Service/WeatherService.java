package dev.patika.batuhanunverdi.Service;

import dev.patika.batuhanunverdi.Model.WeatherModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author Mert Batuhan UNVERDI
 * @since 14.04.2022
 */
@Service
@Slf4j
public class WeatherService implements IWeatherService{
    private final RestTemplate restTemplate;
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> getCurrentWeatherByCity(String cityName) {
        String api = "http://api.weatherapi.com/v1/current.json?key=" +
                "070ddcc1de854979849212501221204&q="+cityName+"&aqi=no";
        ResponseEntity<WeatherModel> result = restTemplate.getForEntity(api,WeatherModel.class);
        WeatherModel weatherModel = result.getBody();
        log.info("Country -> {}, City -> {}, Weather -> {}, Temperature -> {}",
                weatherModel.getLocation().getCountry(),
                weatherModel.getLocation().getName(),
               weatherModel.getCurrent().getCondition().getText(),
                weatherModel.getCurrent().getTemp_c());

        String info = "Country ->" +weatherModel.getLocation().getCountry()+
                ", City -> "+weatherModel.getLocation().getName()+
                ", Weather -> "+weatherModel.getCurrent().getCondition()
                .getText()+
                ", Temperature ->"+weatherModel.getCurrent().getTemp_c();
        return ResponseEntity.ok(info);
    }
}
