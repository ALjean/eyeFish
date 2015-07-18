package com.jean.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by stas on 18.07.15.
 */
@Component
public class DataWaetherDataBaseWriter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 20000)
    public void weatherWriter(){
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
