package dev.patika.batuhanunverdi.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mert Batuhan UNVERDI
 * @since 14.04.2022
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
