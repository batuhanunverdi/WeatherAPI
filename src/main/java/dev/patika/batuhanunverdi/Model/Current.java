package dev.patika.batuhanunverdi.Model;

import lombok.*;


/**
 * @author Mert Batuhan UNVERDI
 * @since 14.04.2022
 */

@Data
public class Current {
    private int last_updated_epoch;
    private String last_updated;
    private double temp_c;
    private double temp_f;
    private boolean is_day;
    private Condition condition;
}
