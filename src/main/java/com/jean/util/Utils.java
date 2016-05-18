package com.jean.util;

import com.jean.Constants;
import com.jean.servlet.model.Coordinates;

/**
 * Created by stas on 18.07.15.
 */
public class Utils {

    public static float kelvinToCelsius(float kelvinTemp) {
        float c = (kelvinTemp - Constants.KELVIN_VALUE) * 1;

        return round(c);
    }

    public static int millibarToMmHg(float millibar) {
        return (int) (millibar / Constants.MILLIBAR_VALUE);
    }

    private static float round(float number) {
        float tmp = number * 100;
        return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / 100;
    }

    public static boolean isPointCircle(double lon, double lat, Coordinates coordinates){
        double hashLon = coordinates.getLongitude();
        double hashLat = coordinates.getLatitude();
        int R = 5;

        return Math.pow((lon-hashLon), 2) + Math.pow((lat-hashLat), 2) <= Math.pow(R, 2);

    }
}
