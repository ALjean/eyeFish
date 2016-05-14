package com.jean.util;

import com.jean.Constants;
import com.jean.entity.Weather;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelBuilder {

    public static List<Weather> buildWeathers(GeneralWeatherStateOWM weatherOwm){
        List<Weather> weathers = new ArrayList<>();


        List<DayWeatherDataOWM> weatherDataOWMs = weatherOwm.getList();
        for (DayWeatherDataOWM weatherDataOWM : weatherDataOWMs) {
            Weather weather = new Weather();
            weather.setCity(weatherOwm.getCity().getName());
            weather.setPressure(Utils.millibarToMmHg(weatherDataOWM.getPressure()));
            weather.setDate(new Date(weatherDataOWM.getDt() * Constants.MULTIPLIER));

            weather.setTempNight(Utils.kelvinToCelsius(weatherDataOWM.getTemp().getNight())); //todo refactoring
            weather.setTempMorn(Utils.kelvinToCelsius(weatherDataOWM.getTemp().getMorn()));
            weather.setTempEven(Utils.kelvinToCelsius(weatherDataOWM.getTemp().getEve()));
            weather.setTempDay(Utils.kelvinToCelsius(weatherDataOWM.getTemp().getDay()));

            weather.setWindSpeed(weatherDataOWM.getSpeed());
//            weather.setWindDeg(weatherDataOWM.getDeg());
            weather.setHumidity(weatherDataOWM.getHumidity());
            weather.setClouds(weatherDataOWM.getClouds());


            weathers.add(weather);
        }
        return weathers;
    }
}
