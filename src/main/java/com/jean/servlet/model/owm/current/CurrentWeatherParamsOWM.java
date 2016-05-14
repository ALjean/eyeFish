package com.jean.servlet.model.owm.current;

import com.jean.servlet.model.owm.hours.AverageWeatherParamsOWM;

/**
 * Created by jean on 14.05.16.
 */
public class CurrentWeatherParamsOWM extends AverageWeatherParamsOWM {

    private float grnd_level;

    public float getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    @Override
    public String toString() {
        return "CurrentWeatherParamsOWM{"+ super.toString() +
                "grnd_level=" + grnd_level +
                '}';
    }
}
