package dev.patika.batuhanunverdi.Model;

import lombok.*;


/**
 * @author Mert Batuhan UNVERDI
 * @since 14.04.2022
 */

@Data
public class Location {
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private int localtime_epoch;
    private String localtime;
}
