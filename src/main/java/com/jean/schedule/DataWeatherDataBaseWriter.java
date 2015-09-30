package com.jean.schedule;

import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.Weather;
import com.jean.model.owm.DayWeatherDataOWM;
import com.jean.model.owm.GeneralWeatherStateOWM;
import com.jean.service.WeatherService;
import com.jean.Constants;
import com.jean.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stas on 18.07.15.
 */
@Component
public class DataWeatherDataBaseWriter {



    @Autowired
    private WeatherDao weatherDao;

    @Autowired
    private WeatherService weatherService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10800000)
    public void weatherWriter() throws CustomDfmException {

        System.out.println("The time is now 1" + dateFormat.format(new Date())) ;
    }



    public void parseOwnWeather() throws CustomDfmException {
        GeneralWeatherStateOWM weatherOwm = weatherService.getDayWeatherState();

        List<Weather> weathers = weatherOwmToDtoList(weatherOwm);

        for (Weather weather : weathers) {
            weatherDao.save(weather);
        }


    }

    private List<Weather> weatherOwmToDtoList(GeneralWeatherStateOWM weatherOwm) {
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
            weather.setWindDeg(weatherDataOWM.getDeg());
            weather.setHumidity(weatherDataOWM.getHumidity());
            weather.setClouds(weatherDataOWM.getClouds());


            weathers.add(weather);
        }
        return weathers;
    }

}