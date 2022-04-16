package dev.patika.batuhanunverdi.Model;

import lombok.*;


/**
 * @author Mert Batuhan UNVERDI
 * @since 12.04.2022
 */
@Data
public class WeatherModel {
    private Location location;
    private Current current;
    private double wind_mph;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private double pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private double humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double vis_km;
    private double vis_miles;
    private double uv;
    private double gust_mph;
    private double gust_kph;
}